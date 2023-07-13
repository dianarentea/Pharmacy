package com.example.Pharmacy.controller;

import com.example.Pharmacy.model.Pharmacy;
import com.example.Pharmacy.model.Pill;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class PharmacyController {

    @GetMapping(value = "/pharmacy")

    public String pharmacy(Model model){
        Pharmacy p1= new Pharmacy("Catena" );
        Pharmacy p2= new Pharmacy("Dr.Max");
        Pharmacy p3= new Pharmacy("Sensiblu");
        Pharmacy p4= new Pharmacy("Dona");

        List<Pharmacy> pharmacyList= List.of(p1,p2,p3,p4);



        model.addAttribute("pharmacyList",pharmacyList);


        return "pharmacy";

    }


}
