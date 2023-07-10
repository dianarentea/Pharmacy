package com.example.Pharmacy.controller;

import com.example.Pharmacy.model.Pharmacy;
import com.example.Pharmacy.model.Pill;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class PharmacyController {

    @GetMapping(value = "/pharmacy")

    public String pharmacy(Model model){
        Pharmacy p1= new Pharmacy("Aspenter", 12.5 );
        Pharmacy p2= new Pharmacy("Nurofen", 20);
        Pharmacy p3= new Pharmacy("Augumentin", 22.93);
        Pharmacy p4= new Pharmacy("Strepsils", 27.50);
        Pharmacy p5= new Pharmacy("Dicarbocalm", 17);
        Pharmacy p6= new Pharmacy("Calcidin", 22.33);
        List<Pharmacy> pharmacyList= List.of(p1,p2,p3,p4,p5,p6);
        model.addAttribute("pharmacyList",pharmacyList);


        return "pharmacy";

    }


}
