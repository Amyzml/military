package com.daicy.military.message;

import com.daicy.military.core.annotation.MessageProcessor;
import com.daicy.military.core.annotation.MessageRoute;
import com.daicy.military.service.IDemoService;

import javax.annotation.Resource;
import java.util.Map;

@MessageProcessor
public class UserMessageProcessor {

    @Resource(name = "demoService")
    private IDemoService demoService;

    @MessageRoute(route = "user.user.create")
    public void userCreate(Map<String, Object> context) {
        System.out.printf("test print" + context);
    }

    @MessageRoute(route = "user.user.delete")
    public void userDelete(Map<String, Object> context) {
        System.out.printf("test print" + context);
    }

    @MessageRoute(route = "user.user.update")
    public void userUpdate(Map<String, Object> context) {
        System.out.printf("test print" + context);
    }
}
