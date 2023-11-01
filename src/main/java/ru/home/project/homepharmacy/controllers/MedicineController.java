package ru.home.project.homepharmacy.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.home.project.homepharmacy.converters.AmountUnitConverter;
import ru.home.project.homepharmacy.converters.GroupConverter;
import ru.home.project.homepharmacy.converters.MedicineConverter;
import ru.home.project.homepharmacy.converters.TypeConverter;
import ru.home.project.homepharmacy.dtos.MedicineDto;
import ru.home.project.homepharmacy.dtos.TypeDto;
import ru.home.project.homepharmacy.entities.Medicine;
import ru.home.project.homepharmacy.repositories.AmountUnitRepository;
import ru.home.project.homepharmacy.services.AmountUnitService;
import ru.home.project.homepharmacy.services.GroupService;
import ru.home.project.homepharmacy.services.MedicineService;
import ru.home.project.homepharmacy.services.TypeService;
import ru.home.project.homepharmacy.utils.FilterData;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("medicine")
public class MedicineController {
    private final MedicineService medicineService;
    private final TypeService typeService;
    private final AmountUnitService amountUnitService;
    private final TypeConverter typeConverter;
    private final AmountUnitConverter amountUnitConverter;
    private final MedicineConverter medicineConverter;
    private final GroupService groupService;
    private final GroupConverter groupConverter;
    Sort sort = Sort.by("title").ascending();

    @PostMapping("listAll")
    public String listAllMedicinesByFilter(@ModelAttribute("filterData") FilterData filterData, Model model) {
        return "redirect:/medicine/listAll?groupId=" + filterData.getGroupId() + "&typeId=" + filterData.getTypeId();
    }

    @GetMapping("listAll")
    public String listAllMedicine(Model model, @RequestParam Long groupId, @RequestParam Long typeId) {
        FilterData filterData = new FilterData();
        filterData.setGroupId(groupId);
        filterData.setTypeId(typeId);
        List<Medicine> medicineList = medicineService.findAllByFilter(filterData);
        model.addAttribute("medicineList", medicineList);
        model.addAttribute("listTypes", typeService.findAll().stream().map(typeConverter::entityToDto).toList());
        model.addAttribute("listGroups", groupService.findAll().stream().map(groupConverter::entityToDto).toList());
        model.addAttribute("filterData", filterData);
        return "medicine/viewAllMedicines";
    }

    @GetMapping("addNewMedicine")
    public String addNewMedicine(Model model) {
        MedicineDto newMedicineDto = MedicineDto.builder().build();
        model.addAttribute("newMedicine", newMedicineDto);
        model.addAttribute("listTypes", typeService.findAll().stream().map(typeConverter::entityToDto).toList());
        model.addAttribute("listAmountUnits", amountUnitService.findAll().stream().map(amountUnitConverter::entityToDto).toList());
        model.addAttribute("listGroups", groupService.findAll().stream().map(groupConverter::entityToDto).toList());
        return "medicine/formAddMedicine";
    }

    @PostMapping("addNewMedicine")
    public String addNewType(@ModelAttribute("newMedicine") MedicineDto newMedicineDto, Model model) {
        medicineService.addNewMedicine(newMedicineDto);
        return "redirect:/medicine/listAll?groupId=0&typeId=0";
    }

    @GetMapping("editMedicine")
    public String editById(@RequestParam Long id, Model model) {
        model.addAttribute("editMedicine", medicineConverter.entityToDto(medicineService.findById(id)));
        model.addAttribute("listTypes", typeService.findAll().stream().map(typeConverter::entityToDto).toList());
        model.addAttribute("listAmountUnits", amountUnitService.findAll().stream().map(amountUnitConverter::entityToDto).toList());
        model.addAttribute("listGroups", groupService.findAll().stream().map(groupConverter::entityToDto).toList());
        return "medicine/formEditMedicine";
    }

    @PostMapping("editMedicine")
    public String editById(@ModelAttribute("editType") MedicineDto medicineDto, Model model) {
        medicineService.editMedicine(medicineDto);
        return "redirect:/medicine/listAll?groupId=0&typeId=0";
    }

    @GetMapping("removeMedicine")
    public String removeById(@RequestParam Long id, Model model) {
        medicineService.removeMedicine(id);
        return "redirect:/medicine/listAll?groupId=0&typeId=0";
    }
}
