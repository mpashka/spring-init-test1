package org.mpashka.spring.init_test1.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MyBean {
    private static final Logger log = LoggerFactory.getLogger(MyBean.class);

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
}
