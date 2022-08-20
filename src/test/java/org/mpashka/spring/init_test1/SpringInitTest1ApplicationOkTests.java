package org.mpashka.spring.init_test1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(properties = { "myBeanFactoryNull=false" })
public class SpringInitTest1ApplicationOkTests {

	@Test
	void contextLoads() {
	}

}
