package com.example.bottle.B.BusinessLogic.dto.label;

import com.example.bottle.B.BusinessLogic.Models.Bottle;
import com.example.bottle.B.BusinessLogic.dto.bottle.CreatedBottle;

public class CreatedLabel {


    private Long idLabel;
    private String shape;
    private String color;
    private String material;
//    private Bottle bottle;
//    private CreatedBottle createdBottle;

//    public CreatedBottle getCreatedBottle() {
//        return createdBottle;
//    }
//
//    public void setCreatedBottle(CreatedBottle createdBottle) {
//        this.createdBottle = createdBottle;
//    }

//    public Bottle getBottle() {
//        return bottle;
//    }

//    public void setBottle(Bottle bottle) {
//        this.bottle = bottle;
//    }

    public Long getIdLabel() {
        return idLabel;
    }

    public void setIdLabel(Long idLabel) {
        this.idLabel = idLabel;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

//    public CreatedBottle getBottle() {
//        return bottle;
//    }
//
//    public void setBottle(CreatedBottle bottle) {
//        this.bottle = bottle;
//    }
}
