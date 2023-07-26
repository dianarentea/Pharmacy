package com.example.Pharmacy.dto;

import lombok.*;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PharmacyOverviewDto {
    private int id;
    private String code;
    private String name;
}
