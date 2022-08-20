package org.mpashka.spring.init_test1.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyBeanFactory implements FactoryBean<MyBean>, ApplicationContextAware {
    private static final Logger log = LoggerFactory.getLogger(MyBeanFactory.class);

    private boolean myBeanFactoryNull;

//    @Autowired
    private MyProps myProps;

    public MyBeanFactory(boolean myBeanFactoryNull) {
        this.myBeanFactoryNull = myBeanFactoryNull;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("App ctx: {}", applicationContext);
    }

    @Override
    public MyBean getObject() {
        MyBean myBean = new MyBean(myProps);
        log.info("Get bean by factory: {}-{}", myProps, myBean);
        return myBean;
    }

    @Override
    public Class<MyBean> getObjectType() {
        log.info("Get bean object type for {}:{}", myProps, myBeanFactoryNull);
//        return MyBean.class;
        return myProps == null && myBeanFactoryNull ? null : MyBean.class;
//        return null;
    }

    public void setMyProps(MyProps myProps) {
        log.info("Set {}", myProps);
        this.myProps = myProps;
    }
}
