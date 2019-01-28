package com.daicy.military.service;
import com.daicy.military.core.Request;
import com.daicy.military.model.DemoModel;
import com.github.pagehelper.Page;

public interface IDemoService {


    /**
     * Isolation.DEFAULT 意思是用数据库本身的事物隔离机制
     * <p>
     * TransactionDefinition.PROPAGATION_REQUIRED：如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。这是默认值。
     * TransactionDefinition.PROPAGATION_REQUIRES_NEW：创建一个新的事务，如果当前存在事务，则把当前事务挂起。
     * TransactionDefinition.PROPAGATION_SUPPORTS：如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。
     * TransactionDefinition.PROPAGATION_NOT_SUPPORTED：以非事务方式运行，如果当前存在事务，则把当前事务挂起。
     * TransactionDefinition.PROPAGATION_NEVER：以非事务方式运行，如果当前存在事务，则抛出异常。
     * TransactionDefinition.PROPAGATION_MANDATORY：如果当前存在事务，则加入该事务；如果当前没有事务，则抛出异常。
     * TransactionDefinition.PROPAGATION_NESTED：如果当前存在事务，则创建一个事务作为当前事务的嵌套事务来运行；如果当前没有事务，则该取值等价于TransactionDefinition.PROPAGATION_REQUIRED。
     *
     * @param o
     * @throws Exception
     */

    void save(DemoModel o) throws Exception;


    void delete(String id) throws Exception;


    void update(DemoModel o) throws Exception;

    DemoModel get(String id) throws Exception;

    Page<DemoModel> findByPage(Request request) throws Exception;

}
