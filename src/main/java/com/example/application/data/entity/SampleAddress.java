package com.example.application.data.entity;

import javax.persistence.Entity;

@Entity
public class SampleAddress extends AbstractEntity {

    private String device1;
    private String device2;

    public String getDevice1() {
        return device1;
    }

    public void setDevice1(String device1) {
        this.device1 = device1;
    }

    public String getDevice2() {
        return device2;
    }

    public void setDevice2(String device2) {
        this.device2 = device2;
    }
}
