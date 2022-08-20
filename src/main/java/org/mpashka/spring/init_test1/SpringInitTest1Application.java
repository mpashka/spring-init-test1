package org.mpashka.spring.init_test1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:my-context.xml")
//@ComponentScan
public class SpringInitTest1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringInitTest1Application.class, args);
	}
}
