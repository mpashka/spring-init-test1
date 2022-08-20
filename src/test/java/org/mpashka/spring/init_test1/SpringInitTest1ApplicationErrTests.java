package org.mpashka.spring.init_test1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test-err.yaml")
class SpringInitTest1ApplicationErrTests {

	@Test
	void contextLoads() {
	}

}
