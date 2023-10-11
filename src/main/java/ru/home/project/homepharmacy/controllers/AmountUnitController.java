package ru.home.project.homepharmacy.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @GetMapping("/listall")
    public String listAllAmountUnit(Model model) {
        List<AmountUnit> amountUnitList = amountUnitService.findAll();
        model.addAttribute("amountUnitList", amountUnitList);
        return "/amountUnit/viewAllAmountUnits";
    }
}
