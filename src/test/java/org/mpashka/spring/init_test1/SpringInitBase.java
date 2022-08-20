package org.mpashka.spring.init_test1;

import org.junit.jupiter.api.Test;
import org.mpashka.spring.init_test1.impl.MyBeanProcessedChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

public abstract class SpringInitBase {

	@Autowired
	private MyBeanProcessedChecker myBeanProcessedChecker;

	@Test
	public void checkBeanProcessed() {
		assertThat(myBeanProcessedChecker, hasProperty("postProcessed", is(true)));
	}
}
