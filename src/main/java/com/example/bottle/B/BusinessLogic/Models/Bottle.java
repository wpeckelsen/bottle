package com.example.bottle.B.BusinessLogic.Models;


import com.example.bottle.B.BusinessLogic.dto.label.CreatedLabel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Bottle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBottle;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String color;

    @Column(length = 50)
    private String factoryCode;

    private int milliliters;
    private int produced;
    private int alcoholPercentage;
    private String factory;
    private LocalDate productionTime;



    @OneToMany(mappedBy = "bottle")
    @JsonIgnore
    List<Label> labels;







    public Bottle() {};

    public Bottle(Long idBottle, String name, String color, String factoryCode, int milliliters, int produced, int alcoholPercentage, String factory, LocalDate productionTime, List<Label> labels) {
        this.idBottle = idBottle;
        this.name = name;
        this.color = color;
        this.factoryCode = factoryCode;
        this.milliliters = milliliters;
        this.produced = produced;
        this.alcoholPercentage = alcoholPercentage;
        this.factory = factory;
        this.productionTime = productionTime;
        this.labels = labels;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public Long getIdBottle() {
        return idBottle;
    }

    public LocalDate getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(LocalDate productionTime) {
        this.productionTime = productionTime;
    }

    public void setIdBottle(Long ID) {
        this.idBottle = ID;
    }

    public int getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public void setAlcoholPercentage(int alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
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

    public String getFactoryCode() {
        return factoryCode;
    }

    public void setFactoryCode(String factoryCode) {
        this.factoryCode = factoryCode;
    }

    public int getProduced() {
        return produced;
    }

    public void setProduced(int produced) {
        this.produced = produced;
    }

//    @OneToMany(mappedBy = "bottle")
//    private Collection<Label> label;
//
//    public Collection<Label> getLabel() {
//        return label;
//    }
//
//    public void setLabel(Collection<Label> label) {
//        this.label = label;
//    }
}
