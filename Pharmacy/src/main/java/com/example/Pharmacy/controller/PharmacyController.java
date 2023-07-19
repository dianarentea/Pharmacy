package com.example.Pharmacy.controller;

import com.example.Pharmacy.model.Pharmacy;
import com.example.Pharmacy.model.Pill;
import com.example.Pharmacy.reposiytory.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.*;
import java.util.stream.Collectors;

@Controller
public class PharmacyController {

    @Autowired
    private PharmacyRepository pharmacyRepository;

    @GetMapping(value = "/pharmacy")
    public String pharmacy(Model model)
    {
      List<Pharmacy> pharmacyList = pharmacyRepository.findAll();
      model.addAttribute("pharmacyList",pharmacyList);

        return "pharmacy";
    }
    @GetMapping(value="/pharmacyForm")
    public String getPharmacyForm(Model model)
    {
        model.addAttribute("pharmacy", new Pharmacy());
        return "pharmacyForm";
    }

    @PostMapping(value="/addPharmacy")
    public String submitPharmacy(@ModelAttribute("pharmacy") Pharmacy pharmacy)
    {
        System.out.println(pharmacy.toString());
        return "redirect:/pharmacy";
    }

}
