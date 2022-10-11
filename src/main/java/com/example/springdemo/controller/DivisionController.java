package com.example.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springdemo.dto.DivisionRequest;
import com.example.springdemo.service.DivisionService;
import com.example.springdemo.entity.Division;

@Controller
@RequestMapping("division")
public class DivisionController {

    @Autowired
    DivisionService divisionService;

    @GetMapping("index")
    public String index(Model model) {
        List<Division> divisionlist = divisionService.findAll();
        model.addAttribute("divisionlist", divisionlist);
        return "division/index";
    }

    @GetMapping("create")
    public String create() {
        return "division/create";
    }

    @PostMapping("store")
    public String store(DivisionRequest divisionRequest) {
        divisionService.insert(divisionRequest);
        return "redirect:index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Division division = divisionService.findOne(id);
        model.addAttribute("division", division);
        return "division/edit";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable Integer id, DivisionRequest divisionRequest) {
        divisionService.update(id, divisionRequest);
        return "redirect:/division/index";
    }
}
