package com.example.bottle.B.BusinessLogic.dto.bottle;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import java.time.LocalDate;


public class CreateBottle {

    @Length(min = 1, max = 50)
    private String name;
    private String color;
    private String factory;

    @Min(1) @Max(10000)
    private int milliliters;
    private int produced;
    private int alcoholPercentage;

    private LocalDate productionTime;

    public CreateBottle(String name, String color, String factory, int milliliters, int produced, int alcoholPercentage, LocalDate productionTime) {
        this.name = name;
        this.color = color;
        this.factory = factory;
        this.milliliters = milliliters;
        this.produced = produced;
        this.alcoholPercentage = alcoholPercentage;
        this.productionTime = productionTime;
    }

    public String getFactory() {
        return factory;
    }
    public void setFactory(String factory) {
        this.factory = factory;
    }
    public int getAlcoholPercentage() {
        return alcoholPercentage;
    }
    public void setAlcoholPercentage(int alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }
    public LocalDate getProductionTime() {
        return productionTime;
    }
    public void setProductionTime(LocalDate productionTime) {
        this.productionTime = productionTime;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getMilliliters() {
        return milliliters;
    }
    public void setMilliliters(int milliliters) {
        this.milliliters = milliliters;
    }
    public int getProduced() {
        return produced;
    }
    public void setProduced(int produced) {
        this.produced = produced;
    }
}