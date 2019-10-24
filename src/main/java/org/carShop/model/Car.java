package org.carShop.model;

public class Car {
    private String brand;
    private String type;
    private int id;

    public Car() {}

    public Car(String brand, String type, int id) {
        this.brand = brand;
        this.type = type;
        this.id = id;
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
}