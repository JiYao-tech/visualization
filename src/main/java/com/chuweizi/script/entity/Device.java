package com.chuweizi.script.entity;

public class Device {
    private String serial;
    private String name;
    private int category;
    private String district;
    private int status;
    private String location;

    public Device() {
    }

    @Override
    public String toString() {
        return "Device{" +
                "serial='" + serial + '\'' +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", district='" + district + '\'' +
                ", status=" + status +
                ", location='" + location + '\'' +
                '}';
    }

    public Device(String serial, String name, int category, String district, int status, String location) {
        this.serial = serial;
        this.name = name;
        this.category = category;
        this.district = district;
        this.status = status;
        this.location = location;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
