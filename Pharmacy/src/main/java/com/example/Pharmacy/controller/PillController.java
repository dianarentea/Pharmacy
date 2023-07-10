package com.example.Pharmacy.controller;

import com.example.Pharmacy.model.Pill;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PillController {

    @GetMapping(value="/description")
    public void description(Model model)
    {
        Pill p1=new Pill("Paracetamol",30, 15,"dureri de cap");

        model.addAttribute("pill", p1);

    }
}
