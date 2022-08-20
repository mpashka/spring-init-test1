package org.mpashka.spring.init_test1;

import org.junit.jupiter.api.Test;
import org.mpashka.spring.init_test1.impl.MyProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

@SpringBootTest(properties = { "myBeanFactoryNull=true" })
class SpringInitTest1ApplicationErrTests {

	@Autowired
	private MyProps myProps;

	@Test
	public void checkBeanProcessFailed() {
		assertThat(myProps, hasProperty("postProcessed", is(true)));
	}

}
