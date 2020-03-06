package com.pacificport.pacificsport.bean;

import java.util.List;

public class Cut {

    private String number;
    private String description;
    private String color;
    private String size;
    private int quantity;

    public Cut() {
    }

    public Cut(String number, String description, String color, String size, int quantity) {
        this.number = number;
        this.description = description;
        this.color = color;
        this.size = size;
        this.quantity = quantity;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cut{" +
                "number='" + number + '\'' +
                ", description='" + description + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
