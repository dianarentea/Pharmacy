package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.PillFormDto;
import com.example.Pharmacy.dto.PillOverviewDto;
import com.example.Pharmacy.model.Pharmacy;
import com.example.Pharmacy.model.Pill;
import com.example.Pharmacy.reposiytory.PharmacyRepository;
import com.example.Pharmacy.reposiytory.PillRepository;
import com.example.Pharmacy.service.PillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PillController {

    @Autowired
    private PharmacyRepository pharmacyRepository;
    @Autowired
    private PillService pillService;

    @GetMapping(value="/pillOverview")
    public String pillOverview(Model model)
    {
        List<PillOverviewDto> pillList=pillService.getAllPills();
        model.addAttribute("pillList", pillList);
        return "pillOverview";
    }
    @GetMapping(value="/pillForm")
    public String getPillForm(Model model)
    {
        model.addAttribute("pill", new PillFormDto());
       //de modificat cu service pt phamracy
        List<Pharmacy> pharmacyList = pharmacyRepository.findAll();
        model.addAttribute("pharmacyList", pharmacyList);
        return "pillForm";
    }

    @PostMapping(value="/submitPill")
    public String submitPill(@ModelAttribute("pill") PillFormDto pill, Model model)
    {
            pillService.savePill(pill);
            return "redirect:/pillOverview";
        }


    @GetMapping(value= "/deletePill")
    public String deletePill(@RequestParam("id") int pillId){
        pillService.deletePill(pillId);
        return "redirect:/pillOverview";
    }

    //@GetMapping(value="/findPill")
    //@ResponseBody
       //     public Pill findPill(@RequestParam("id") int pillId){

      //  return pillRepository.findById(pillId).get();
  //  }
    @GetMapping(value = "/editPill")
    public String editPillForm(@RequestParam("id") int pillId, Model model) {
        Pill pill =pillService.findPill(pillId);
        model.addAttribute("pill", pill);
        List<Pharmacy> pharmacyList = pharmacyRepository.findAll();
        model.addAttribute("pharmacyList", pharmacyList);
        return "pillForm";
    }
    @GetMapping(value = "/shop-single")
    public String shopsingle(@RequestParam("id") int pillId, Model model)
    {
        Pill pill =pillService.findPill(pillId);
        model.addAttribute("pill", pill);
        List<Pharmacy> pharmacyList = pharmacyRepository.findAll();
        return "shop-single";
    }
    @GetMapping(value = "/sortPills")
    public String sortPills(@RequestParam("sortBy") String sortBy, Model model) {
        List<PillOverviewDto> sortedPillList = null;

        switch (sortBy) {
            case "name_asc":
                sortedPillList = pillService.sortPillsByNameAsc();
                break;
            case "name_desc":
                sortedPillList = pillService.sortPillsByNameDesc();
                break;
            case "price_asc":
                sortedPillList = pillService.sortPillsByPriceAsc();
                break;
            case "price_desc":
                sortedPillList = pillService.sortPillsByPriceDesc();
                break;
            // Add more cases for other sorting criteria if needed.

            default:
                sortedPillList = pillService.getAllPills();
                break;
        }

        model.addAttribute("pillList", sortedPillList);
        return "shop";
    }
}
