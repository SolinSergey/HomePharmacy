package ru.home.project.homepharmacy.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
