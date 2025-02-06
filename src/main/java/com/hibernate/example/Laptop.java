package com.hibernate.example;

import jakarta.persistence.*;
import org.hibernate.annotations.ManyToAny;

import java.util.List;

@Entity
public class Laptop {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String brand;
    private String model;
    //    @ManyToOne
    //    private Aline aline;

    @ManyToMany(mappedBy = "laptops")
    private List<Aline> alines;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Aline> getAlines() {
        return alines;
    }

    public void setAlines(List<Aline> alines) {
        this.alines = alines;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
