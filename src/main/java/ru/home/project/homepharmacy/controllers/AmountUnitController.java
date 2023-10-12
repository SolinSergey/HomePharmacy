package ru.home.project.homepharmacy.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.home.project.homepharmacy.converters.AmountUnitConverter;
import ru.home.project.homepharmacy.dtos.AmountUnitDto;
import ru.home.project.homepharmacy.dtos.TypeDto;
import ru.home.project.homepharmacy.entities.AmountUnit;
import ru.home.project.homepharmacy.entities.Type;
import ru.home.project.homepharmacy.services.AmountUnitService;
import ru.home.project.homepharmacy.services.TypeService;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/amountUnit")
public class AmountUnitController {
    private final AmountUnitService amountUnitService;
    private final AmountUnitConverter amountUnitConverter;
    @GetMapping("/listAll")
    public String listAllAmountUnit(Model model) {
        List<AmountUnit> amountUnitList = amountUnitService.findAll();
        model.addAttribute("amountUnitList", amountUnitList);
        return "/amountUnit/viewAllAmountUnits";
    }

    @GetMapping("/addNewAmountUnit")
    public String addNewAmountUnit(Model model) {
        AmountUnitDto newAmountUnitDto=AmountUnitDto.builder().build();
        model.addAttribute("newAmountUnit", newAmountUnitDto);
        return "/amountUnit/formAddAmountUnit";
    }
    @PostMapping("/addNewAmountUnit")
    public String addNewType(@ModelAttribute("newAmountUnit") AmountUnitDto newAmountUnitDto, Model model) {
        amountUnitService.addNewAmountUnit(newAmountUnitDto);
        return "redirect:/amountUnit/listAll";
    }
    @GetMapping("/editAmountUnit")
    public String editById(@RequestParam Long id, Model model){
        model.addAttribute("editAmountUnit",amountUnitConverter.entityToDto(amountUnitService.findById(id)));
        return "/amountUnit/formEditAmountUnit";
    }
    @PostMapping("/editAmountUnit")
    public String editById(@ModelAttribute("editAmountUnit") AmountUnitDto editAmountUnitDto, Model model) {
        amountUnitService.editAmountUnit(editAmountUnitDto);
        return "redirect:/amountUnit/listAll";
    }
    @GetMapping("/removeAmountUnit")
    public String removeById(@RequestParam Long id, Model model){
        amountUnitService.removeAmountUnit(id);
        return "redirect:/amountUnit/listAll";
    }
}
