package com.example.Pharmacy.controller;

import com.example.Pharmacy.model.Pill;
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

    @GetMapping(value="/pill")
    public String description(Model model)
    {
        List<Pill> pillList = pillRepository.findAll();
        model.addAttribute("pillList", pillList);
        return "pill";
    }
    @GetMapping(value="/pillForm")
    public String getPillForm(Model model)
    {
        model.addAttribute("pill", new Pill());
        return "pill";
    }

    @PostMapping(value="/addPill")
    public String submitPill(@ModelAttribute("pill") Pill pill, Model model)
    {
       pillRepository.save(pill);
       return "redirect:/pill";
    }

    @GetMapping(value= "/deletePill")
    public String submitPill(@RequestParam("id") int pillId){
        pillRepository.deleteById(pillId);
        return "redirect:/pill";

    }

    @GetMapping(value="/findPill")
    @ResponseBody
            public Pill findPill(@RequestParam("id") int pillId){
        return pillRepository.findById(pillId).get();
    }

}
