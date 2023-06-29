package com.datadog.ese.sandbox.micrometer;

import java.io.IOException;
import java.net.InetSocketAddress;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import io.prometheus.client.exporter.HTTPServer;

public class Prometheus {

    static public void start() {
        PrometheusMeterRegistry registry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
        Gauge
                .builder("system.memory", Runtime.getRuntime(), Runtime::freeMemory)
                .baseUnit("bytes")
                .description("Free memory")
                .tag("foo", "bar")
                .register(registry);

        try {
            new HTTPServer(new InetSocketAddress(8080), registry.getPrometheusRegistry(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }       
    }

}
