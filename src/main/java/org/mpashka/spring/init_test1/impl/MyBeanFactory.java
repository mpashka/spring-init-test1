package org.mpashka.spring.init_test1.impl;

import org.springframework.beans.factory.FactoryBean;

public class MyBeanFactory implements FactoryBean<MyBeanFactory.MyBean> {
    private boolean myBeanFactoryNull;

    private MyBeanProcessedChecker myBeanProcessedChecker;

    public MyBeanFactory(boolean myBeanFactoryNull) {
        this.myBeanFactoryNull = myBeanFactoryNull;
    }

    @Override
    public MyBean getObject() {
        return new MyBean(myBeanProcessedChecker);
    }

    @Override
    public Class<MyBean> getObjectType() {
        return myBeanProcessedChecker == null && myBeanFactoryNull ? null : MyBean.class;
    }

    public void setMyBeanProcessedChecker(MyBeanProcessedChecker myBeanProcessedChecker) {
        this.myBeanProcessedChecker = myBeanProcessedChecker;
    }

    public static class MyBean {
        private MyBeanProcessedChecker myBeanProcessedChecker;

        public MyBean(MyBeanProcessedChecker myBeanProcessedChecker) {
            this.myBeanProcessedChecker = myBeanProcessedChecker;
        }
    }
}
