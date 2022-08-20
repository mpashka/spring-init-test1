package org.mpashka.spring.init_test1.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    private static final Logger log = LoggerFactory.getLogger(MyConfig.class);

    @Bean("myPostProcessor")
    public MyPostProcessor myBeanFactory() {
        return new MyPostProcessor();
    }
}
