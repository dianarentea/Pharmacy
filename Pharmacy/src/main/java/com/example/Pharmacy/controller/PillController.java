package com.example.Pharmacy.controller;

import com.example.Pharmacy.model.Pharmacy;
import com.example.Pharmacy.model.Pill;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PillController {

    @GetMapping(value="/description")
    public void description(Model model)
    {
        Pharmacy ph1= new Pharmacy("DrMax" );
        Pharmacy ph2= new Pharmacy("Catena");

        Pill p1=new Pill("Aspenter",12.5, 40,"tensiune arteriala",ph1);
        Pill p2=new Pill("Nurofen",20, 15,"dureri de cap",ph2);
        Pill p3=new Pill("Augumentin", 22.93, 30, "migrene",ph1);
        Pill p4=new Pill("Strepsils", 27.50, 30, "dureri de gat",ph1);
        Pill p5 =new Pill("Dicarbocalm", 17, 25, "arsuri",ph1);
        Pill p6= new Pill("Calcidin", 80, 20, "carenta de calciu",ph2);
        List<Pill> pillList= List.of(p1, p2,p3,p4,p5,p6);
        System.out.println(p1.getPharmacy().getName());
        model.addAttribute("pillList", pillList);
    }
}
