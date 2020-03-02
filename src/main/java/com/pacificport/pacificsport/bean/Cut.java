package com.pacificport.pacificsport.bean;

import java.util.List;

public class Cut {

    private String type;
    private Integer number;
    private String description;
    private List<Color> colors;

    public Cut() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    @Override
    public String toString() {
        return "Cut{" +
                "type='" + type + '\'' +
                ", number=" + number +
                ", description='" + description + '\'' +
                ", colors=" + colors +
                '}';
    }
}
