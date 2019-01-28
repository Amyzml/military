package com.daicy.military.controller;

import com.daicy.military.core.Response;
import com.daicy.military.model.Agency;
import com.daicy.military.model.BaseModel;
import com.daicy.military.service.AgencyService;
import com.github.pagehelper.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/identity")
public class AgencyController {
    @Autowired
    private AgencyService agencyService;
    @ApiOperation(value = "创建军事机构")
    @RequestMapping(value = "/admin/addAgency",method = {RequestMethod.POST})
    public Response addAgency(Agency agency) throws Exception {
        Map<String, Object> ob =  agencyService.addAgency(agency);
       BaseModel baseModel = new BaseModel();
       baseModel.setExtra(ob);
        return new Response(baseModel,HttpStatus.OK);
    }
    @ApiOperation(value = "修改军事机构")
    @RequestMapping(value = "/admin/updateAgency",method = {RequestMethod.POST})
    public Response updateAgency(Agency agency) throws Exception {
       agencyService.updateAgency(agency);

        return new Response(HttpStatus.OK);
    }
    @ApiOperation(value = "上架，下架")
    @RequestMapping(value = "/admin/updateStatus",method = {RequestMethod.POST})
    public Response updateStatus(Integer status,String ids) throws Exception {
        agencyService.updateStatus(status,ids);
        return new Response(HttpStatus.OK);
    }

    @ApiOperation(value ="查询详情")
    @RequestMapping(value = "/admin/getAgencyById",method = {RequestMethod.GET})
    public Response getAgencyById(Integer id) throws Exception {
        Agency agency = agencyService.getAgencyById(id);
        return new Response(agency,HttpStatus.OK);
    }
    @ApiOperation(value ="分页")
    @RequestMapping(value = "/admin/fenYe",method = {RequestMethod.GET})
    public Response fenYe(Integer PageNum,Integer PageSize,String level) throws Exception {

        Page<Agency> info = agencyService.findAll(PageNum,PageSize,level);
        return new Response(info,HttpStatus.OK);
    }
    @ApiOperation(value ="前台的显示")
    @RequestMapping(value = "/views",method = {RequestMethod.GET})
    public Response views() throws Exception {
        List<Agency> agency = agencyService.findAllViews();
        return new Response(agency,HttpStatus.OK);
    }
}
