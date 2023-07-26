package com.example.Pharmacy.dto;

import com.example.Pharmacy.model.Pharmacy;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PillFormDto {
    private int id;
    private String name;
    private int price;
    private int stockNumber;
    private String description;
    private String imageName;
    private Pharmacy pharmacy;
}
