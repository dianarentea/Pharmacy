package com.example.Pharmacy.mapper;


import com.example.Pharmacy.dto.PharmacyFormDto;
import com.example.Pharmacy.dto.PharmacyOverviewDto;
import com.example.Pharmacy.model.Pharmacy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PharmacyMapper {

    public List<PharmacyOverviewDto> getPharmacyList(List<Pharmacy> pharmacyList)
    {
        return pharmacyList.stream()
                .map(pharmacy ->mapToPharmacyDto(pharmacy))
                .collect(Collectors.toList());
    }

    public PharmacyOverviewDto mapToPharmacyDto(Pharmacy pharmacy)
    {
        return PharmacyOverviewDto.builder()
                .id(pharmacy.getId())
                .code(pharmacy.getCode())
                .name(pharmacy.getName())
                .build();
    }

    public Pharmacy mapToPharmacy(PharmacyFormDto pharmacyDto){
        Pharmacy pharmacy = Pharmacy.builder()
                .id(pharmacyDto.getId())
                .name(pharmacyDto.getName())
                .code(pharmacyDto.getCode())
                .build();
        return pharmacy;
    }
}
