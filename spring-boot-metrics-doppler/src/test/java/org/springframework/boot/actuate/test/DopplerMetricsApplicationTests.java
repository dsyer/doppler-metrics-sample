package org.springframework.boot.actuate.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.actuate.metrics.doppler.EnableDopplerMetrics;
import org.springframework.boot.actuate.test.DopplerMetricsApplicationTests.DopplerMetricsApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DopplerMetricsApplication.class)
@IntegrationTest
public class DopplerMetricsApplicationTests {

	@Test
	public void contextLoads() {
	}

	@SpringBootApplication
	@EnableDopplerMetrics
	protected static class DopplerMetricsApplication {

		public static void main(String[] args) {
			new SpringApplicationBuilder(DopplerMetricsApplication.class).profiles("dev")
					.run(args);
		}
	}

}
