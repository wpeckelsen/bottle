package com.example.bottle.B.BusinessLogic.dto.bottle;
import com.example.bottle.B.BusinessLogic.Models.Label;
import com.example.bottle.B.BusinessLogic.dto.label.CreatedLabel;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class CreatedBottle {


    public CreatedBottle() {};

    private Long idBottle;
    private LocalDate productionTime;
    private String name;
    private String color;
    private String factoryCode;
    private String factory;
    private int milliliters;
    private int produced;
    private int alcoholPercentage;

    private List<CreatedLabel> labels;



    public CreatedBottle(Long idBottle, LocalDate productionTime, String name, String color, String factoryCode, String factory, int milliliters, int produced, int alcoholPercentage) {
        this.idBottle = idBottle;
        this.productionTime = productionTime;
        this.name = name;
        this.color = color;
        this.factoryCode = factoryCode;
        this.factory = factory;
        this.milliliters = milliliters;
        this.produced = produced;
        this.alcoholPercentage = alcoholPercentage;
    }

    public List<CreatedLabel> getLabels() {
        return labels;
    }
    public void setLabels(List<CreatedLabel> labels) {
        this.labels = labels;
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
