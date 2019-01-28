package com.daicy.military.core;


import net.sf.json.JSONObject;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MessagePublisher {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void publish(String exchange, String routingKey, String route, Map<String, Object> context) {
        JSONObject json = new JSONObject();
        json.put("route", route);
        json.put("context", context);
        rabbitTemplate.convertAndSend(exchange, routingKey, json.toString());
    }
}
