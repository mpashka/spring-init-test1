package org.mpashka.spring.init_test1.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyBeanProcessedChecker myBeanProcessedChecker) {
            myBeanProcessedChecker.setPostProcessed(true);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyBeanProcessedChecker myBeanProcessedChecker) {
            myBeanProcessedChecker.setPostProcessed(true);
        }
        return bean;
    }
}
