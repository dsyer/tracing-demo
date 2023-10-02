package com.example.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.actuate.observability.AutoConfigureObservability;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureObservability
class DemoApplicationTests {

	private static Log log = LogFactory.getLog(DemoApplicationTests.class);

	@Autowired
	private RestTemplateBuilder builder;

	@Autowired
	private ObservationRegistry observations;

	@LocalServerPort
	private int port;

	@Test
	void contextLoads() {
		Observation observation = Observation.createNotStarted("test", this.observations);
		observation.observe(() -> {
			log.info("Testing");
			builder.build().getForObject("http://localhost:" + port, String.class);
		});
	}

}
