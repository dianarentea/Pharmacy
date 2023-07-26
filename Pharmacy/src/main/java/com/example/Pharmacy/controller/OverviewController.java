package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.PillOverviewDto;
import com.example.Pharmacy.reposiytory.PharmacyRepository;
import com.example.Pharmacy.service.PillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.List;

@Controller
public class OverviewController {
    @Autowired
    private PharmacyRepository pharmacyRepository;
    @Autowired
    private PillService pillService;
    @GetMapping(value = "/index")
    public String index(Model model)
    {
        List<PillOverviewDto> pillList=pillService.getAllPills();
        Collections.shuffle(pillList);
        model.addAttribute("pillList", pillList);
        return "index";
    }
    @GetMapping(value = "/about")
    public String about(Model model)
    {
        return "about";
    }
    @GetMapping(value = "/cart")
    public String cart(Model model)
    {
        return "cart";
    }
    @GetMapping(value = "/checkout")
    public String checkout(Model model)
    {
        return "checkout";
    }
    @GetMapping(value = "/contact")
    public String contact(Model model)
    {
        return "contact";
    }
    @GetMapping(value = "/shop")
    public String shop(Model model)
    {
        return "shop";
    }
    @GetMapping(value = "/shop-single")
    public String shopsingle(Model model)
    {
        return "shop-single";
    }
    @GetMapping(value = "/thankyou")
    public String thankyou(Model model)
    {
        return "thankyou";
    }
}
