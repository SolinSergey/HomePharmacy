package ru.home.project.homepharmacy.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.home.project.homepharmacy.dtos.TypeDto;
import ru.home.project.homepharmacy.entities.Type;
import ru.home.project.homepharmacy.services.TypeService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/type")
public class TypeController {
    private final TypeService typeService;
    @GetMapping("/listAll")
    public String listAllTypes(Model model) {
        List<Type> typeList = typeService.findAll();
        model.addAttribute("typeList", typeList);
        return "/type/viewAllTypes";
    }

    @GetMapping("/addNewType")
    public String addNewType(Model model) {
        TypeDto newTypeDto=TypeDto.builder().build();
        model.addAttribute("newType", newTypeDto);
        return "/type/formAddType";
    }

    @PostMapping("/addNewType")
    public String addNewType(@ModelAttribute("newType") TypeDto newTypeDto, Model model) {
        typeService.addNewType(newTypeDto);
        return "redirect:/type/listAll";
    }
}
