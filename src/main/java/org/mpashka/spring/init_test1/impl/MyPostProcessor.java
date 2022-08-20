package org.mpashka.spring.init_test1.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyPostProcessor implements BeanPostProcessor {
    private static final Logger log = LoggerFactory.getLogger(MyPostProcessor.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.endsWith("myBeanFactory") || beanName.endsWith("myProps")) {
            log.info("Post process {} before: {}", beanName, bean);
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.endsWith("myBeanFactory") || beanName.endsWith("myProps")) {
            log.info("Post process {} after: {}", beanName, bean);
        }
        if (bean instanceof MyProps myProps) {
            myProps.setPostProcessed(true);
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
