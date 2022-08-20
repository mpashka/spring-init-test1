package org.mpashka.spring.init_test1.impl;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "my.props")
public class MyProps {
    private String myVal;

    public String getMyVal() {
        return myVal;
    }

    public void setMyVal(String myVal) {
        this.myVal = myVal;
    }
}
