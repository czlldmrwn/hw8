package com.mirea.kt.hw6;

public class Store {
    private String name;
    private String address;
    private int hoursOpen;
    private int hoursClose;

    public Store(String name, String address, int hoursOpen, int hoursClose) {
        this.name = name;
        this.address = address;
        this.hoursOpen = hoursOpen;
        this.hoursClose = hoursClose;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getHoursOpen() {
        return hoursOpen;
    }

    public int getHoursClose() {
        return hoursClose;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHoursOpen(int hoursOpen) {
        this.hoursOpen = hoursOpen;
    }

    public void setHoursClose(int hoursClose) {
        this.hoursClose = hoursClose;
    }
}
