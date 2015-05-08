package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.metrics.writer.Delta;
import org.springframework.boot.actuate.metrics.writer.MetricWriter;

import events.EnvelopeOuterClass.Envelope;
import events.Metric;

/**
 * Created by vcarvalho on 4/16/15.
 */
public class DopplerMetricWriter implements MetricWriter {

	private static final Logger logger = LoggerFactory
			.getLogger(DopplerMetricWriter.class);

	private DopplerClient client;
	private String origin;
	

	public DopplerMetricWriter(DopplerProperties properties) {
		this.origin = properties.getOrigin();
		this.client = new DopplerClient(properties.getHost(), properties.getPort(), properties.getSecret());
	}

	@Override
	public void increment(Delta<?> delta) {
		throw new UnsupportedOperationException("No counters in Doppler");
	}

	@Override
	public void set(org.springframework.boot.actuate.metrics.Metric<?> metric) {
		if (metric.getValue() instanceof Long) {
			writeLong(metric);
		}
		else {
			writeDouble(metric);
		}
	}

	private void writeLong(org.springframework.boot.actuate.metrics.Metric<?> metric) {
		try {
			Envelope envelope = Envelope
					.newBuilder()
					.setEventType(Envelope.EventType.ValueMetric)
					.setOrigin(origin)
					.setTimestamp(metric.getTimestamp().getTime())
					.setValueMetric(
							Metric.ValueMetric.newBuilder().setUnit("count")
									.setValue(metric.getValue().doubleValue())
									.setName(metric.getName()).build()).build();
			client.publish(envelope);
		}
		catch (Exception e) {
			logger.error(String.format("Error reporting Gauge %s ", metric.getName()), e);
		}
	}

	private void writeDouble(org.springframework.boot.actuate.metrics.Metric<?> metric) {
		try {
			Envelope envelope = Envelope
					.newBuilder()
					.setEventType(Envelope.EventType.ValueMetric)
					.setOrigin(origin)
					.setTimestamp(metric.getTimestamp().getTime())
					.setValueMetric(
							Metric.ValueMetric.newBuilder().setUnit("gauge")
									.setValue(metric.getValue().doubleValue())
									.setName(metric.getName()).build()).build();
			client.publish(envelope);
		}
		catch (Exception e) {
			logger.error(String.format("Error reporting Gauge %s ", metric.getName()), e);
		}
	}

	@Override
	public void reset(String metricName) {
		set(new org.springframework.boot.actuate.metrics.Metric<Number>(metricName, 0.));
	}

}
