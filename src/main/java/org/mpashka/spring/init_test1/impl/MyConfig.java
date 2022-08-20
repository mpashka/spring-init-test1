package org.mpashka.spring.init_test1.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(MyProps.class)
public class MyConfig {

    private static final Logger log = LoggerFactory.getLogger(MyConfig.class);

//    @Bean("myBeanFactory2")
    public MyBeanFactory2 myBeanFactory() {
        return new MyBeanFactory2();
    }

    @Bean
    public MyBean myBean(MyProps myProps) {
        return new MyBean(myProps);
    }
}
