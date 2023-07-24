package com.example.Pharmacy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OverviewController {
    @GetMapping(value="/index")
    public String index()
    {
        return "index";
    }
    @GetMapping(value="/charts")
    public String charts()
    {
        return "charts";
    }
    @GetMapping(value="/layout-sidenav-light")
    public String layout()
    {
        return "layout-sidenav-light";
    }

}
