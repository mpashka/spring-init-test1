package org.mpashka.spring.init_test1.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyBeanFactory2 implements FactoryBean, ApplicationContextAware {
    private static final Logger log = LoggerFactory.getLogger(MyBeanFactory2.class);

    @Value("#{@'my.props-org.mpashka.spring.init_test1.impl.MyProps'}")
//    @Autowired
    private MyProps myProps;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("App ctx: {}", applicationContext);
    }

    @Override
    public Object getObject() {
        log.info("Get bean by factory: {}-{}", myProps, myProps == null ? null : myProps.isPostProcessed());
        return new MyBean(myProps);
    }

    @Override
    public Class getObjectType() {
//            log.info("Get bean object type");
//        return MyBean.class;
        return null;
//        return Object.class;
    }

    @Value("#{@'my.props-org.mpashka.spring.init_test1.impl.MyProps'}")
    public void setMyProps(MyProps myProps) {
        this.myProps = myProps;
    }
}
