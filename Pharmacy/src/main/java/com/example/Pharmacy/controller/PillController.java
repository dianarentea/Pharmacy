package com.example.Pharmacy.controller;

import com.example.Pharmacy.model.Pharmacy;
import com.example.Pharmacy.model.Pill;
import com.example.Pharmacy.reposiytory.PharmacyRepository;
import com.example.Pharmacy.reposiytory.PillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PillController {

    @Autowired
    private PillRepository pillRepository;
    @Autowired
    private PharmacyRepository pharmacyRepository;

    @GetMapping(value="/pillOverview")
    public String description(Model model)
    {
        List<Pill> pillList = pillRepository.findAll();
        model.addAttribute("pillList", pillList);
        return "pillOverview";
    }
    @GetMapping(value="/pillForm")
    public String getPillForm(Model model)
    {
        model.addAttribute("pill", new Pill());
        List<Pharmacy> pharmacyList = pharmacyRepository.findAll();
        model.addAttribute("pharmacyList", pharmacyList);
        return "pillForm";
    }

    @PostMapping(value="/submitPill")
    public String submitPill(@ModelAttribute("pill") Pill pill, Model model)
    {
       pillRepository.save(pill);
       System.out.println(pill.getPharmacy().getName());
       return "redirect:/pillOverview";
    }

    @GetMapping(value= "/deletePill")
    public String deletePill(@RequestParam("id") int pillId){
        pillRepository.deleteById(pillId);
        return "redirect:/pillOverview";

    }

    @GetMapping(value="/findPill")
    @ResponseBody
            public Pill findPill(@RequestParam("id") int pillId){

        return pillRepository.findById(pillId).get();
    }
    @GetMapping(value = "/editPill")
    public String editPillForm(@RequestParam("id") int pillId, Model model) {
        Pill pill = pillRepository.findById(pillId).orElse(null);
        model.addAttribute("pill", pill);
        List<Pharmacy> pharmacyList = pharmacyRepository.findAll();
        model.addAttribute("pharmacyList", pharmacyList);
        return "pillForm";
    }

}
