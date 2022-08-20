package org.mpashka.spring.init_test1.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController implements ApplicationContextAware {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private MyProps myProps;

//    @Autowired
//    @Qualifier("&myBeanFactory")
    private MyBeanFactory myBeanFactory;

//    @Autowired
//    @Qualifier("myBeanFactory")
    private MyBean myBean;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("App ctx: {}", applicationContext);
    }

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot! " + myProps.getMyVal() /*+ " / " + ((MyBean) myBean).myVal()*/;
    }

    @GetMapping("/bean")
    public String beans() {
        return myBean + " / " + myBeanFactory;
    }

    @GetMapping("/init-jdbc")
    public String initJdbc() {
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE customers(" +
                "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");
        return "Greetings from Spring Boot!";
    }

}