package com.example.programmeringeksamen.controller;


import com.example.programmeringeksamen.model.Sogn;
import com.example.programmeringeksamen.service.KommuneService;
import com.example.programmeringeksamen.service.SognService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@Controller
public class MainController {

    @Autowired
    SognService sognService;

    @Autowired
    KommuneService kommuneService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("sogne", sognService.findAll());
        return "index";
    }

    @GetMapping("/kommuner")
    public String kommuner(Model model){
        model.addAttribute("kommuner", kommuneService.findAll());
        return "kommuner";
    }

    @GetMapping("/create")
    public String create(Model model){
        //add kommuner to be selected from
        model.addAttribute("kommuner", kommuneService.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Sogn sogn, WebRequest request){
        sogn.setDatoForNedlukning(LocalDate.parse(request.getParameter("datoForNedlukning")));
        sognService.create(sogn);
        return"redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model){
        model.addAttribute("sogn", sognService.findById(id));
        //add kommuner to choose from
        model.addAttribute("kommuner", kommuneService.findAll());
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Sogn sogn){
        sognService.update(sogn);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        sognService.deleteById(id);
        return "redirect:/";
    }
}
