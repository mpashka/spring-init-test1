package org.mpashka.spring.init_test1.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MyProps {
    private static final Logger log = LoggerFactory.getLogger(MyProps.class);

    private boolean postProcessed;

    public MyProps() {
        log.info("My Props Create: {}", this);
    }

    public boolean isPostProcessed() {
        return postProcessed;
    }

    public void setPostProcessed(boolean postProcessed) {
        this.postProcessed = postProcessed;
    }
}
