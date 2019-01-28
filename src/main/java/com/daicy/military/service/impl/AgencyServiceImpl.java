package com.daicy.military.service.impl;

import com.daicy.military.dao.AgencyMapper;
import com.daicy.military.exception.MilitaryException;
import com.daicy.military.model.Agency;
import com.daicy.military.service.AgencyService;
import com.daicy.military.util.CommonUtil;
import com.daicy.military.util.DateFormatUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AgencyServiceImpl implements AgencyService {
    @Autowired
    private AgencyMapper agencyMapper;

    @Override
    public Map<String, Object> addAgency(Agency agency) throws MilitaryException {
        Map<String, Object> extra = new HashMap<>();
        try{
            System.out.println(" ----- ");
            Agency ag = agencyMapper.findBySort(agency.getSort(),agency.getLevel());
            System.out.println("ag -- " + ag);
            if (ag == null){
                agency.setCreateTime(DateFormatUtil.longToDateFormat(System.currentTimeMillis(),"yyyy-MM-dd HH:mm:ss"));
                agency.setUpdateTime(DateFormatUtil.longToDateFormat(System.currentTimeMillis(),"yyyy-MM-dd HH:mm:ss"));
                agency.setNum("M"+DateFormatUtil.longToDateFormat(System.currentTimeMillis(),"YYYYMMddHHmmssSSS"));
                agency.setStatus(1);
                //agency.setCountNum(0);
                System.out.println(" ====  " + agency);
                agencyMapper.insertSelective(agency);
                System.out.println(" ====22222  " + agency);
                extra.put("sort","0");
            }else{
                extra.put("sort","1");
            }

        }catch (Exception e){
            e.printStackTrace();
           // throw new MilitaryException();
        }
        return extra;
    }

    @Override
    public void updateAgency(Agency agency) throws MilitaryException {
        try{
            agency.setUpdateTime(DateFormatUtil.longToDateFormat(System.currentTimeMillis(),"yyyy-MM-dd HH:mm:ss"));
            agencyMapper.updateByPrimaryKeySelective(agency);
        }catch (Exception e){
            throw new MilitaryException();
      }
    }

    @Override
    public void updateStatus(Integer status, String ids) throws MilitaryException {
        try{
            String[] id = ids.split(",");
            agencyMapper.updateStatus(status,id);
        }catch (Exception e){
            e.printStackTrace();
           // throw new MilitaryException();
        }
    }

    @Override
    public Agency getAgencyById(Integer id) {
      return agencyMapper.selectByPrimaryKey(id);
    }

    @Override
    public Page<Agency> findAll(Integer pageNum, Integer pageSize, String level) {
        PageHelper.startPage(pageNum,pageSize);
        List<Agency> list = null;
        if (CommonUtil.isNullOrEmpty(level)){
             list = agencyMapper.findAll();
        }else {
             list = agencyMapper.findAllBylevel(level);
        }
        return (Page<Agency>)list;
    }

    @Override
    public List<Agency> findAllViews() {
        List<Agency> list = agencyMapper.findAll();
        return list;
    }
}
