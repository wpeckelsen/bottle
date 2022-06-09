package com.example.bottle.B.BusinessLogic.Models;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLabel;

    private String shape;
    private String color;
    private String material;


    @JsonIgnore
    @OneToMany(mappedBy = "label")
    Set<Bottle> bottles;






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

    public Set<Bottle> getBottles() {
        return bottles;
    }

    public void setBottles(Set<Bottle> bottles) {
        this.bottles = bottles;
    }
}
