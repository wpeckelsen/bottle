package com.example.bottle.B.BusinessLogic.Models;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLabel;

    private String shape;
    private String color;
    private String material;



    @ManyToOne
    @JoinColumn(name="bottle_idbottle")
    private Bottle bottle;





    public Bottle getBottle() {
        return bottle;
    }

    public void setBottle(Bottle bottle) {
        this.bottle = bottle;
    }

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
