package com.example.Pharmacy.controller;

import com.example.Pharmacy.model.Pharmacy;
import com.example.Pharmacy.model.Pill;
import com.example.Pharmacy.repository.PillRepository;
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
        //Pharmacy ph1= new Pharmacy();
        //ph1.setName("Dr Max");
       // Pharmacy ph2= new Pharmacy();
        //ph2.setName("Catena");

        //Pill p1=new Pill("Aspenter",12.5, 40,"tensiune arteriala",ph1);
        //Pill p2=new Pill("Nurofen",20, 15,"dureri de cap",ph2);
        //Pill p3=new Pill("Augumentin", 22.93, 30, "migrene",ph1);
        //Pill p4=new Pill("Strepsils", 27.50, 30, "dureri de gat",ph1);
        //Pill p5 =new Pill("Dicarbocalm", 17, 25, "arsuri",ph1);
        //Pill p6= new Pill("Calcidin", 80, 20, "carenta de calciu",ph2);
        //List<Pill> pillList= List.of(p1, p2,p3,p4,p5,p6);
        List<Pill> pillList= pillRepository.findAll();
        //System.out.println(pillList.get(2));

        //System.out.println(p1.getPharmacy().getName());
        model.addAttribute("pillList", pillList);
        return "pill";
    }
    @GetMapping(value="/pillForm")
    public String getPillForm(Model model)
    {
        model.addAttribute("pill", new Pill());
        return "pillForm";
    }

    @PostMapping(value="/addPill")
    public String submitPill(@ModelAttribute("pill") Pill pill)
    {
        System.out.println(pill.toString());
        return "pillForm";
    }
}
