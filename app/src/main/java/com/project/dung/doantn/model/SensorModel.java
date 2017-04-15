package com.project.dung.doantn.model;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Dung on 4/12/2017.
 */

public class SensorModel {
    private String imgSensor;
    private String sensorName;

    public SensorModel(String imgSensor, String sensorName) {

        this.imgSensor = imgSensor;
        this.sensorName = sensorName;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getImgSensor() {
        return imgSensor;
    }

    public void setImgSensor(String imgSensor) {
        this.imgSensor = imgSensor;
    }
}
