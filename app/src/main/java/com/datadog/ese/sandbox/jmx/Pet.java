package com.datadog.ese.sandbox.jmx;

import java.util.concurrent.ThreadLocalRandom;

public class Pet implements PetMBean {

    private String breed;

    public Pet(String breed) {
        this.breed = breed;
    }

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public int getHR() {
        return ThreadLocalRandom.current().nextInt(60, 120);
    }

}
