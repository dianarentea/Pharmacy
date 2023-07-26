package com.example.Pharmacy.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PharmacyFormDto {

    private int id;
    private String code;
    private String name;
}
