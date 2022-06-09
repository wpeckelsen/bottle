package com.example.bottle.B.BusinessLogic.dto.bottle;
import com.example.bottle.B.BusinessLogic.Models.Label;

import java.time.LocalDate;

public class CreatedBottle {

    private Long idBottle;
    private LocalDate productionTime;
    private String name;
    private String color;
    private String factoryCode;
    private String factory;
    private int milliliters;
    private int produced;
    private int alcoholPercentage;
    private Label label;



    public CreatedBottle() {};

    public Label getLabel() {
        return label;
    }
    public void setLabel(Label label) {
        this.label = label;
    }

    public LocalDate getProductionTime() {
        return productionTime;
    }
    public void setProductionTime(LocalDate productionTime) {
        this.productionTime = productionTime;
    }
    public String getFactoryCode() {
        return factoryCode;
    }
    public void setFactoryCode(String factoryCode) {
        this.factoryCode = factoryCode;
    }
    public String getFactory() {
        return factory;
    }
    public void setFactory(String factory) {
        this.factory = factory;
    }
    public int getProduced() {
        return produced;
    }
    public void setProduced(int produced) {
        this.produced = produced;
    }
    public int getAlcoholPercentage() {
        return alcoholPercentage;
    }
    public void setAlcoholPercentage(int alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }
    public Long getIdBottle() {
        return idBottle;
    }
    public void setIdBottle(Long idBottle) {
        this.idBottle = idBottle;
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
}
