package org.carShop.model;

public class Car {
    private static int cursorCarId;

    private String brand;
    private String type;
    private int id;

    public Car(String brand, String type) {
        this.brand = brand;
        this.type = type;
        this.id = giveId();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    private static int giveId() {
        int id = cursorCarId;
        cursorCarId++;
        return id;
    }
}