package com.daicy.military.core;
import com.daicy.military.core.annotation.MessageProcessor;
import com.daicy.military.core.annotation.MessageRoute;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@RabbitListener(queues = "daicy-queue-sample")
public class MessageHandler {
    private static Logger log = Logger.getLogger(MessageHandler.class);

    @Autowired
    private ApplicationContext context;

    @Value("${daicy.message.thread.pool.size}")
    private int messageThreadPoolNum = 3;

    private Map<String, Object> processorMethods = new HashMap<>();

    private ExecutorService executorService = Executors.newFixedThreadPool(messageThreadPoolNum);

    @PostConstruct
    private void init() {
        Map<String, Object> processors = context.getBeansWithAnnotation(MessageProcessor.class);
        for (Map.Entry<String, Object> entry : processors.entrySet()) {
            Method[] methods = entry.getValue().getClass().getDeclaredMethods();
            for (Method method : methods) {
                MessageRoute route = method.getDeclaredAnnotation(MessageRoute.class);
                if (route != null) {
                    Map<String, Object> invoke = new HashMap<>();
                    invoke.put("instance", entry.getValue());
                    invoke.put("method", method);
                    processorMethods.put(route.route(), invoke);
                }
            }
        }
    }

    /**
     *process 没有抛出异常,也就是这条消息处理的成功失败都不会再收到消息。
     * 如果抛出异常的化rabbitmq 会不停的推送这条消息。
     */
    @RabbitHandler
    public void process(String messages) {
        JSONObject message = JSONObject.fromObject(messages);
        String route = message.getString("route");
        Map<String, Object> body = (Map<String, Object>) message.get("context");
        if (!processorMethods.containsKey(route)) {
            log.debug("the route [" + route + "] not processor");
            return;
        }
        //线程处理不许要返回值则用execute 否则用submit 可以拿到返回值

        executorService.execute(new ProcessTask(route, body));

    }


    class ProcessTask implements Runnable {
        private String route;
        private Map<String, Object> body;

        public ProcessTask(String route, Map<String, Object> body) {
            this.route = route;
            this.body = body;
        }

        @Override
        public void run() {
            Map<String, Object> processor = (Map<String, Object>) processorMethods.get(route);
            try {
                ((Method) processor.get("method")).invoke(processor.get("instance"), body);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("reflect invoke message processor error  route is " + route);
            }
        }
    }
}