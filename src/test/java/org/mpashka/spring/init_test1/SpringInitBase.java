package org.mpashka.spring.init_test1;

import org.junit.jupiter.api.Test;
import org.mpashka.spring.init_test1.impl.MyProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

public abstract class SpringInitBase {

	@Autowired
	private MyProps myProps;

	@Test
	public void checkBeanProcessed() {
		assertThat(myProps, hasProperty("postProcessed", is(true)));
	}

	@SpringBootTest
	@ActiveProfiles("expected-init")
	public static class SpringInitTest1ApplicationOkTest extends SpringInitBase {
	}

	@SpringBootTest
	@ActiveProfiles("show-error")
	public static class SpringInitTest1ApplicationErrTest extends SpringInitBase {
	}
}
