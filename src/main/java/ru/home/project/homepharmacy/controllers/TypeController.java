package ru.home.project.homepharmacy.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.home.project.homepharmacy.converters.TypeConverter;
import ru.home.project.homepharmacy.dtos.TypeDto;
import ru.home.project.homepharmacy.entities.Medicine;
import ru.home.project.homepharmacy.entities.Type;
import ru.home.project.homepharmacy.services.TypeService;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("type")
public class TypeController {
    private final TypeService typeService;
    private final TypeConverter typeConverter;
    @GetMapping("listAll")
    public String listAllTypes(Model model) {
        List<Type> typeList = typeService.findAll();
        model.addAttribute("typeList", typeList);
        return "type/viewAllTypes";
    }

    @GetMapping("addNewType")
    public String addNewType(Model model) {
        TypeDto newTypeDto=TypeDto.builder().build();
        model.addAttribute("newType", newTypeDto);
        return "type/formAddType";
    }

    @PostMapping("addNewType")
    public String addNewType(@ModelAttribute("newType") TypeDto newTypeDto, Model model) {
        typeService.addNewType(newTypeDto);
        return "redirect:/type/listAll";
    }

    @GetMapping("editType")
    public String editById(@RequestParam Long id, Model model){
        model.addAttribute("editType",typeConverter.entityToDto(typeService.findById(id)));
        return "type/formEditType";
    }
    @PostMapping("editType")
    public String editById(@ModelAttribute("editType") TypeDto editTypeDto, Model model) {
        typeService.editType(editTypeDto);
        return "redirect:/type/listAll";
    }
    @GetMapping("removeType")
    public String removeById(@RequestParam Long id, Model model){
        typeService.removeType(id);
        return "redirect:/type/listAll";
    }

}
