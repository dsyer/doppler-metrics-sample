package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(DopplerProperties.class)
public class DopplerMetricsApplication {

	@Bean
	public DopplerMetricWriter dopplerMetricWriter(DopplerProperties doppler) {
		return new DopplerMetricWriter(doppler);
	}

	public static void main(String[] args) {
		SpringApplication.run(DopplerMetricsApplication.class, args);
	}
}
