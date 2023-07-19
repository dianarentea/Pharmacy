package com.example.Pharmacy.controller;

import com.example.Pharmacy.model.Pharmacy;
import com.example.Pharmacy.reposiytory.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.*;

@Controller
public class PharmacyController {

    @Autowired
    private PharmacyRepository pharmacyRepository;

    @GetMapping(value = "/pharmacyOverview")
    public String pharmacy(Model model)
    {
      List<Pharmacy> pharmacyList = pharmacyRepository.findAll();
      model.addAttribute("pharmacyList",pharmacyList);

        return "pharmacyOverview";
    }
    @GetMapping(value="/pharmacyForm")
    public String getPharmacyForm(Model model)
    {
        model.addAttribute("pharmacy", new Pharmacy());
        return "pharmacyForm";
    }

    @PostMapping(value = "/submitPharmacy")
    public String submitPharmacy(@ModelAttribute("pharmacy") Pharmacy pharmacy) {
        if (pharmacy.getId() !=0 ) {
            // If the pharmacy has an ID, it means we are editing an existing pharmacy
            Pharmacy existingPharmacy = pharmacyRepository.findById(pharmacy.getId()).orElse(null);
            if (existingPharmacy != null) {
                existingPharmacy.setCode(pharmacy.getCode());
                existingPharmacy.setName(pharmacy.getName());
                // Update other fields as needed
                pharmacyRepository.save(existingPharmacy);
            }
        } else {
            // If the pharmacy doesn't have an ID, it means we are adding a new pharmacy
            pharmacyRepository.save(pharmacy);
        }
        return "redirect:/pharmacyOverview";
    }

    @GetMapping(value="/deletePharmacy")
    public String deletePill(@RequestParam("id")int pharmacyId)
    {
        pharmacyRepository.deleteById(pharmacyId);
        return "redirect:/pharmacyOverview";
    }
    @GetMapping(value = "/editPharmacy")
    public String editPharmacyForm(@RequestParam("id") int pharmacyId, Model model) {
        Pharmacy pharmacy = pharmacyRepository.findById(pharmacyId).orElse(null);
        model.addAttribute("pharmacy", pharmacy);
        return "pharmacyForm";
    }

}
