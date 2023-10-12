package ru.home.project.homepharmacy.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.home.project.homepharmacy.entities.Medicine;
import ru.home.project.homepharmacy.services.MedicineService;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/medicine")
public class MedicineController {
    private final MedicineService medicineService;
    @GetMapping("/listall")
    public String listAllMedicine(Model model) {
        List<Medicine> medicineList = medicineService.findAll();
        model.addAttribute("medicineList", medicineList);
        return "/medicine/viewAllMedicines";
    }
}
