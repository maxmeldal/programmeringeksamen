package com.example.programmeringeksamen.controller;

import com.example.programmeringeksamen.repository.KommuneRepository;
import com.example.programmeringeksamen.repository.SognRepository;
import com.example.programmeringeksamen.service.KommuneService;
import com.example.programmeringeksamen.service.SognService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    SognService sognService;

    @Autowired
    KommuneService kommuneService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("sogne", sognService.findAll());
        return "index";
    }
}
