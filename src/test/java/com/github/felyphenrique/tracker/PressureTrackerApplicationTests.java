package com.github.felyphenrique.tracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest()
@ExtendWith({ RestDocumentationExtension.class, SpringExtension.class })
class PressureTrackerApplicationTests {

	@RegisterExtension()
	final RestDocumentationExtension restDocumentation = new RestDocumentationExtension();

	@BeforeEach()
	private void setUp(WebApplicationContext appContext, RestDocumentationContextProvider restContext) {

	}

	@Test
	void contextLoads() {
	}
}
