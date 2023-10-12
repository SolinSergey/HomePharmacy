package ru.home.project.homepharmacy.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.home.project.homepharmacy.converters.AmountUnitConverter;
import ru.home.project.homepharmacy.converters.TypeConverter;
import ru.home.project.homepharmacy.dtos.MedicineDto;
import ru.home.project.homepharmacy.dtos.TypeDto;
import ru.home.project.homepharmacy.entities.Medicine;
import ru.home.project.homepharmacy.repositories.AmountUnitRepository;
import ru.home.project.homepharmacy.services.AmountUnitService;
import ru.home.project.homepharmacy.services.MedicineService;
import ru.home.project.homepharmacy.services.TypeService;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/medicine")
public class MedicineController {
    private final MedicineService medicineService;
    private final TypeService typeService;
    private final AmountUnitService amountUnitService;
    private final TypeConverter typeConverter;
    private final AmountUnitConverter amountUnitConverter;

    @GetMapping("/listAll")
    public String listAllMedicine(Model model) {
        List<Medicine> medicineList = medicineService.findAll();
        model.addAttribute("medicineList", medicineList);
        return "/medicine/viewAllMedicines";
    }

    @GetMapping("/addNewMedicine")
    public String addNewMedicine(Model model) {
        MedicineDto newMedicineDto=new MedicineDto();
        model.addAttribute("newMedicine", newMedicineDto);
        model.addAttribute("listTypes",typeService.findAll().stream().map(typeConverter::entityToDto).toList());
        model.addAttribute("listAmountUnits",amountUnitService.findAll().stream().map(amountUnitConverter::entityToDto).toList());
        return "/medicine/formAddMedicine";
    }

    @PostMapping("/addNewMedicine")
    public String addNewType(@ModelAttribute("newMedicine") MedicineDto newMedicineDto, Model model) {
        medicineService.addNewMedicine(newMedicineDto);
        return "redirect:/medicine/listAll";
    }
}
