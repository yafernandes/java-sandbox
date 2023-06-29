package com.datadog.ese.sandbox.jmx;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

public class SimpleAgent {

    private static MBeanServer mbs = null;

    public static void register() {
        mbs = ManagementFactory.getPlatformMBeanServer();
        try {
            mbs.registerMBean(new Pet("X"), new ObjectName("Zoo:Kingdom=Animalia,Genus=Canis,name=Bits"));
            mbs.registerMBean(new Pet("Beagle"), new ObjectName("Zoo:Kingdom=Animalia,Genus=Canis,name=Snoopy"));
            mbs.registerMBean(new Pet("Clone"), new ObjectName("Zoo:Kingdom=Animalia,Genus=Ovis,name=Dolly"));
            mbs.registerMBean(new Pet("Mixed"), new ObjectName("Zoo:Kingdom=Animalia,Genus=Felis,name=Grumpy Cat"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}