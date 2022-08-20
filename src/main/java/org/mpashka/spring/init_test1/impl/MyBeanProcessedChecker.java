package org.mpashka.spring.init_test1.impl;

import org.springframework.stereotype.Component;

@Component
public class MyBeanProcessedChecker {

    private boolean postProcessed;

    public boolean isPostProcessed() {
        return postProcessed;
    }

    public void setPostProcessed(boolean postProcessed) {
        this.postProcessed = postProcessed;
    }
}
