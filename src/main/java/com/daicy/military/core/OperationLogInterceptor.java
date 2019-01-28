package com.daicy.military.core;

import com.daicy.military.model.Log;
import com.daicy.military.util.DateFormatUtil;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.MessageFormat;

public class OperationLogInterceptor implements HandlerInterceptor {

    private static Logger log = Logger.getLogger(OperationLogInterceptor.class);

    @Autowired
    private MessagePublisher messagePublisher;


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String username = (String) request.getAttribute("username");
        String role = (String) request.getAttribute("role");
        String operation = (String) request.getAttribute("operation");
        String object = (String) request.getAttribute("object");
        String desc = (String) request.getAttribute("desc");
        Long time = System.currentTimeMillis();
        int status = response.getStatus();
        Boolean success = true;
        if (status > 230) success = false;
        String msg = MessageFormat.format("用户:{0}-角色:{1}-时间:{2}-操作:{3}-对象:{4}-成功:{5}-描述:{6}", username, role,
                DateFormatUtil.longToDateFormat(time, ""), operation, object, success, desc);
        Log log = new Log();
        log.setRole(role);
        log.setAction(operation);
        log.setOperator(username);
        log.setService_name("sample");
        log.setCreate_time(DateFormatUtil.longToDateFormat(System.currentTimeMillis(), null));
        log.setContent(msg);
        String sendMsg = JSONObject.fromObject(log).toString();
//        messagePublisher.publish();
        //这里可以修改为日志模块的交换机和routingkey
    }
}
