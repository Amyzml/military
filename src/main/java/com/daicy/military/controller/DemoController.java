package com.daicy.military.controller;
import com.daicy.military.core.MessagePublisher;
import com.daicy.military.core.Request;
import com.daicy.military.core.Response;
import com.daicy.military.model.DemoModel;
import com.daicy.military.service.IDemoService;
import com.daicy.military.util.OperationLogUtil;
import com.github.pagehelper.Page;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/demo")
public class DemoController {
    private static Logger log = Logger.getLogger(DemoController.class);


    @Autowired
    private HttpServletRequest request;


    @Autowired
    private MessagePublisher messagePublisher;

   @Autowired
    private IDemoService demoService;


    @ApiOperation(value = "create")
    @RequestMapping(method = {RequestMethod.PUT})
    public Response save(@RequestBody DemoModel simple) throws Exception {
        OperationLogUtil.write(request, "save", "sample", "test");
        demoService.save(simple);
        return new Response(HttpStatus.CREATED);
    }


    @ApiOperation(value = "delete")
    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
    public Response delete(@PathVariable("id") String id) throws Exception {
        demoService.delete(id);
        return new Response(HttpStatus.ACCEPTED);
    }


    @ApiOperation(value = "update")
    @RequestMapping(method = {RequestMethod.POST})
    public Response update(@RequestBody DemoModel simple) throws Exception {
        demoService.update(simple);
        return new Response(HttpStatus.ACCEPTED);
    }


    @ApiOperation(value = "getById")
    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public Response getById(@PathVariable("id") String id) throws Exception {
        Map<String, Object> context = new HashMap<>();
        context.put("key", "value");
        messagePublisher.publish("daicy-exchange-user", "user.user", "user.user.create", context);
        DemoModel model = demoService.get(id);
        return new Response<>(model, HttpStatus.OK);
    }


    @ApiOperation(value = "getByPage")
    @RequestMapping(method = {RequestMethod.GET})
    public Response findByPage(@RequestParam("pageNum") int pageNum,
                               @RequestParam("pageSize") int pageSize,
                               @RequestParam(value = "name", required = false) String name,
                               @RequestParam(value = "createTimeStart", required = false) String createTimeStart,
                               @RequestParam(value = "createTimeEnd", required = false) String createTimeEnd,
                               @RequestParam(value = "orderBy", required = false) String orderBy
    ) throws Exception {
        DemoModel demo = new DemoModel();
        demo.setName(name);
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("createTimeStart", createTimeStart);
        conditions.put("createTimeEnd", createTimeEnd);
        Request<DemoModel> request = new Request<>(pageNum, pageSize, demo, conditions, orderBy);
        Page<DemoModel> res = demoService.findByPage(request);
        return new Response<>(res, HttpStatus.OK);
    }

}
