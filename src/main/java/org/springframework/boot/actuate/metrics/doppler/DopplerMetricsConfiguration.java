package org.springframework.boot.actuate.metrics.doppler;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DopplerProperties.class)
public class DopplerMetricsConfiguration {

	@Bean
	public DopplerMetricWriter dopplerMetricWriter(DopplerProperties doppler) {
		return new DopplerMetricWriter(doppler);
	}

}
