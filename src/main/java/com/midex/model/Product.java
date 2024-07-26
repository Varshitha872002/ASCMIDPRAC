package com.midex.model;

public class Product {
    private int id;
    private static String name;
    private double price;

    // default constructor
    public Product() {}

    // constructor
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // getters and setters

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id =id;
    }

    public static String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        // validation for price
        if (price < 0) {
            throw new IllegalArgumentException("price cannot be negative");
        }
        this.price = price;
    }

}
