package com.example.Pharmacy.controller;

import com.example.Pharmacy.model.Pill;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PillController {

    @GetMapping(value="/description")
    public String description(Model model)
    {
        Pill p1=new Pill("Paracetamol",30, 15,"dureri de cap");
        Pill p2=new Pill("Decasept", 15, 30, "dureri de gat");
        Pill p3= new Pill("Magnerot", 80, 20, "contracturi musculare");
        List<Pill> pillList= List.of(p1, p2,p3);
        model.addAttribute("pillList", pillList);

        return "description";
    }
}
