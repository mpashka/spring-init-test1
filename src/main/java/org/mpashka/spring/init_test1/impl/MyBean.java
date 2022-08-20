package org.mpashka.spring.init_test1.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.PostConstruct;

public class MyBean {
    private static final Logger log = LoggerFactory.getLogger(MyBean.class);

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    private TransactionTemplate transactionTemplate;

    private MyProps myProps;

    public MyBean(MyProps myProps) {
        this.myProps = myProps;
        log.info("My bean create with props: {}", myProps.getMyVal());
    }

    @PostConstruct
    public void init() {
        log.info("My bean init with props: {}", myProps.getMyVal());
    }

    public String myVal() {
        return myProps.getMyVal();
    }

    public String checkTransaction() {
        return checkTransaction0();
    }

    @Transactional
    public String checkTransaction0() {
        return String.valueOf(TransactionSynchronizationManager.isActualTransactionActive());
    }

    @Transactional
    public String checkTransaction1() {
        TransactionStatus transactionStatus = transactionManager.getTransaction(new TransactionDefinition() {
            @Override
            public int getPropagationBehavior() {
                return TransactionDefinition.PROPAGATION_SUPPORTS;
            }
        });
        return transactionStatus.toString();
    }
}
