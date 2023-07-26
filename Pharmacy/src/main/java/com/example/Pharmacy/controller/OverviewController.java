package com.example.Pharmacy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class OverviewController {
    @GetMapping(value = "/index")
    public String index(Model model)
    {
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
