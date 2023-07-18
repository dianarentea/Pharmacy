package com.example.Pharmacy.controller;

import com.example.Pharmacy.model.Pharmacy;
import com.example.Pharmacy.model.Pill;
import com.example.Pharmacy.repository.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class PharmacyController {

    @Autowired
    private PharmacyRepository pharmacyRepository;
    @GetMapping(value = "/pharmacy")

    public String pharmacy(Model model){
       // Pharmacy p1= new Pharmacy("Dr Max");
       // Pharmacy p2= new Pharmacy("Catena");
        //Pharmacy p3= new Pharmacy("Dona");
       // Pharmacy p4= new Pharmacy("Sensiblu");
       // List<Pharmacy> pharmacyList= List.of(p1,p2,p3,p4);

        List<Pharmacy> pharmacyList=pharmacyRepository.findAll();
        model.addAttribute("pharmacyList",pharmacyList);
        return "pharmacy";
    }
    @GetMapping(value="/pharmacyForm")
    public String getPharmacyForm(Model model)
    {
        model.addAttribute("pharmacy", new Pharmacy());
        return "pharmacyForm";
    }

    @PostMapping(value="/submitPharmacy")
    public String submitPharmacy(@ModelAttribute("pharmacy") Pharmacy pharmacy, Model model)
    {
        pharmacyRepository.save(pharmacy);
        System.out.println(pharmacy.toString());
        return "redirect:/pharmacy";
    }

    @GetMapping(value="/deleteEmployee")
    public String deleteEmployee(@RequestParam("id") int pharmacyId)
    {
        pharmacyRepository.deleteById(pharmacyId);
        return "redirect:/pharmacy";
    }

}
