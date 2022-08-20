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

    @Value("#{@'my.props-org.mpashka.spring.init_test1.impl.MyProps'}")
//    @Autowired
    private MyProps myProps;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("App ctx: {}", applicationContext);
    }

    @Override
    public MyBean getObject() {
        log.info("Get bean by factory: {}-{}", myProps, myProps == null ? null : myProps.getMyVal());
        return new MyBean(myProps);
    }

    @Override
    public Class<MyBean> getObjectType() {
//            log.info("Get bean object type");
//        return MyBean.class;
//        return myProps == null ? null : MyBean.class;
        return null;
    }

    public void setMyProps(MyProps myProps) {
        this.myProps = myProps;
    }
}
