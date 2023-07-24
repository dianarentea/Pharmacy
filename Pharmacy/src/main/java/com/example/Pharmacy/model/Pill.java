package com.example.Pharmacy.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="t_pill")
public class Pill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;
    @Column(name="price")
    private int price;
    @Column(name="stock_number")
    private int stockNumber;
    @Column(name="description")
    private String description;
    @ManyToOne
    @JoinColumn(name="id_pharmacy")
    private Pharmacy pharmacy;

}
