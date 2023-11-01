package ru.home.project.homepharmacy.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.home.project.homepharmacy.dtos.MedicineDto;
import ru.home.project.homepharmacy.dtos.TypeDto;
import ru.home.project.homepharmacy.entities.AmountUnit;
import ru.home.project.homepharmacy.entities.Group;
import ru.home.project.homepharmacy.entities.Medicine;
import ru.home.project.homepharmacy.entities.Type;
import ru.home.project.homepharmacy.repositories.AmountUnitRepository;
import ru.home.project.homepharmacy.repositories.GroupRepository;
import ru.home.project.homepharmacy.repositories.MedicineRepository;
import ru.home.project.homepharmacy.repositories.TypeRepository;
import ru.home.project.homepharmacy.utils.FilterData;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicineService {
    private final MedicineRepository medicineRepository;
    private final AmountUnitRepository amountUnitRepository;
    private final TypeRepository typeRepository;
    private final GroupRepository groupRepository;
    Sort sort = Sort.by("title").ascending();

    public Medicine findById(Long id) {
        return medicineRepository.findById(id).get();
    }

    public List<Medicine> findAll() {
        return medicineRepository.findAll(sort);
    }

    public void addNewMedicine(MedicineDto newMedicineDto) {
        Type type = typeRepository.findById(newMedicineDto.getTypeId()).get();
        AmountUnit amountUnit = amountUnitRepository.findById(newMedicineDto.getAmountId()).get();
        Group group = groupRepository.findById(newMedicineDto.getGroupId()).get();
        Medicine medicine = medicineRepository.findByAmountUnitAndTypeAndGroupAndTitle(amountUnit, type, group, newMedicineDto.getTitle(), sort);
        if (medicine == null) {
            medicine = new Medicine();
            medicine.setId(0l);
            medicine.setType(type);
            medicine.setAmountUnit(amountUnit);
            medicine.setTitle(newMedicineDto.getTitle());
            medicine.setAmount(newMedicineDto.getAmount());
            medicine.setGroup(group);
            medicineRepository.save(medicine);
        }
    }

    public void editMedicine(MedicineDto medicineDto) {
        Medicine medicine = medicineRepository.findById(medicineDto.getId()).get();
        Type type = typeRepository.findById(medicineDto.getTypeId()).get();
        AmountUnit amountUnit = amountUnitRepository.findById(medicineDto.getAmountId()).get();
        Group group = groupRepository.findById(medicineDto.getGroupId()).get();
        medicine.setTitle(medicineDto.getTitle());
        medicine.setType(type);
        medicine.setAmountUnit(amountUnit);
        medicine.setAmount(medicineDto.getAmount());
        medicine.setGroup(group);
        medicineRepository.save(medicine);
    }

    public void removeMedicine(Long id) {
        medicineRepository.deleteById(id);
    }

    public List<Medicine> findAllByFilter(FilterData filterData) {
        if (filterData.getGroupId() != 0 && filterData.getTypeId() == 0) {
            return medicineRepository.findAllByGroup(groupRepository.findById(filterData.getGroupId()).get(), sort);
        } else if (filterData.getGroupId() == 0 && filterData.getTypeId() != 0) {
            return medicineRepository.findAllByType(typeRepository.findById(filterData.getTypeId()).get(), sort);
        } else if (filterData.getGroupId() != 0 && filterData.getTypeId() != 0) {
            return medicineRepository.findAllByGroupAndType(groupRepository.findById(filterData.getGroupId()).get(),
                    typeRepository.findById(filterData.getTypeId()).get(), sort);
        } else {
            return medicineRepository.findAll(sort);
        }
    }
}
