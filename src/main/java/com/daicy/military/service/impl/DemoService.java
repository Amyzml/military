package com.daicy.military.service.impl;
import com.daicy.military.core.Request;
import com.daicy.military.dao.DemoDao;
import com.daicy.military.model.DemoModel;
import com.daicy.military.service.IDemoService;
import com.daicy.military.util.DateFormatUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service("demoService")
public class DemoService implements IDemoService {

    @Autowired
    private DemoDao demoDap;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    @Override
    public void save(DemoModel o) throws Exception {
        o.setId(UUID.randomUUID().toString());
        o.setCreateTime(DateFormatUtil.longToDateFormat(System.currentTimeMillis(),null));
        demoDap.save(o);
    }


    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    @Override
    public void delete(String id) throws Exception {
        demoDap.delete(id);
    }


    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    @Override
    public void update(DemoModel o) throws Exception {
        o.setUpdateTime(DateFormatUtil.longToDateFormat(System.currentTimeMillis(),null));
        demoDap.update(o);

    }

    @Override
    public DemoModel get(String id) throws Exception {
        return demoDap.get(id);
    }

    @Override
    public Page<DemoModel> findByPage(Request request) throws Exception {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        return demoDap.findByPage(request);
    }

}
