package com.datadog.ese.sandbox;

import java.util.Arrays;

import com.datadog.ese.sandbox.jmx.SimpleAgent;
import com.datadog.ese.sandbox.micrometer.Prometheus;

public class App {

    public static void main(String[] args) {
        if (Arrays.stream(args).anyMatch("prometheus"::equalsIgnoreCase)) {
            Prometheus.start();
        }

        if (Arrays.stream(args).anyMatch("jmx"::equalsIgnoreCase)) {
            SimpleAgent.register();
        }

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
