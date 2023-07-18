package com.example.Pharmacy.model;

import jakarta.persistence.*;

@Entity
@Table(name="t_pharmacy")
public class Pharmacy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    public Pharmacy(String name) {
        this.name = name;
    }

    public Pharmacy() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Pharmacy{" +
                "name='" + name + '\'' +

                '}';
    }
}

