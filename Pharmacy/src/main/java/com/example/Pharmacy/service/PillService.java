package com.example.Pharmacy.service;

import com.example.Pharmacy.dto.PillFormDto;
import com.example.Pharmacy.dto.PillOverviewDto;
import com.example.Pharmacy.mapper.PillMapper;
import com.example.Pharmacy.model.Pill;
import com.example.Pharmacy.model.Pharmacy;
import com.example.Pharmacy.reposiytory.PharmacyRepository;
import com.example.Pharmacy.reposiytory.PillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PillService {
    @Autowired
    private PillRepository pillRepository;
    @Autowired
    private PharmacyRepository pharmacyRepository;
    @Autowired
    private PillMapper pillMapper;
    public List<PillOverviewDto> getAllPills()
    {
        List<Pill> pillList=pillRepository.findAll();
        return pillMapper.getPillList(pillList);
    }
    public void savePill(PillFormDto pillDto)
    {
        Pill pill = pillMapper.mapToPill(pillDto);
        if (pill.getId() != 0)
        {
            Pill existingPill = pillRepository.findById(pill.getId()).orElse(null);
            if (existingPill != null) {
                existingPill.setId(pill.getId());
                existingPill.setName(pill.getName());
                existingPill.setPrice(pill.getPrice());
                existingPill.setStockNumber(pill.getStockNumber());
                existingPill.setDescription(pill.getDescription());
                existingPill.setPharmacy(pill.getPharmacy());
                pillRepository.save(existingPill);
            }
        }
        else {
            pillRepository.save(pill);
        }
    }
    public void deletePill(int pillId)
    {
        pillRepository.deleteById(pillId);
    }
    public Pill findPill(int pillId)
    {
        return pillRepository.findById(pillId).orElse(null);
    }

}
