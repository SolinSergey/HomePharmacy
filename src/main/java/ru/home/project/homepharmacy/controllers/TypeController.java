package ru.home.project.homepharmacy.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.home.project.homepharmacy.entities.Type;
import ru.home.project.homepharmacy.services.TypeService;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/types")
public class TypeController {
    private final TypeService typeService;
    @GetMapping("/listall")
    public String listAllTypes(Model model) {
        List<Type> typeList = typeService.findAll();
        model.addAttribute("typeList", typeList);
        return "/types/viewAllTypes";
    }
}
