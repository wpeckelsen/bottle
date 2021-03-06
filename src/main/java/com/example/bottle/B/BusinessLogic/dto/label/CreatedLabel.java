package com.example.bottle.B.BusinessLogic.dto.label;

import com.example.bottle.B.BusinessLogic.Models.Bottle;
import com.example.bottle.B.BusinessLogic.dto.bottle.CreatedBottle;

public class CreatedLabel {


    private Long idLabel;
    private String shape;
    private String color;
    private String material;


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

}
