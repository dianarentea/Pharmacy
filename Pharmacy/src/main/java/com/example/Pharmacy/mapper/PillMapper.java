package com.example.Pharmacy.mapper;

import com.example.Pharmacy.dto.PillFormDto;
import com.example.Pharmacy.dto.PillOverviewDto;
import com.example.Pharmacy.model.Pill;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PillMapper {

    public List<PillOverviewDto> getPillList(List<Pill> pillList)
    {
        return pillList.stream()
                .map(pill -> mapToPillDto(pill))
                .collect(Collectors.toList());

    }

    public PillOverviewDto mapToPillDto(Pill pill)
    {
        return PillOverviewDto.builder()
                .id(pill.getId())
                .name(pill.getName())
                .price(pill.getPrice())
                .stockNumber(pill.getStockNumber())
                .description(pill.getDescription())
                .pharmacy(pill.getPharmacy())
                .build();
    }
    public Pill mapToPill(PillFormDto pillDto)
    {
        Pill pill= Pill.builder()
                .id(pillDto.getId())
                .name(pillDto.getName())
                .price(pillDto.getPrice())
                .stockNumber(pillDto.getStockNumber())
                .description(pillDto.getDescription())
                .pharmacy(pillDto.getPharmacy())
                .build();
        return pill;
    }
}
