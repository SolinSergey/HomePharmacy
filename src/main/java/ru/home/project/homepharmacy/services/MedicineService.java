package ru.home.project.homepharmacy.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.home.project.homepharmacy.dtos.MedicineDto;
import ru.home.project.homepharmacy.dtos.TypeDto;
import ru.home.project.homepharmacy.entities.AmountUnit;
import ru.home.project.homepharmacy.entities.Medicine;
import ru.home.project.homepharmacy.entities.Type;
import ru.home.project.homepharmacy.repositories.AmountUnitRepository;
import ru.home.project.homepharmacy.repositories.MedicineRepository;
import ru.home.project.homepharmacy.repositories.TypeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicineService {
    private final MedicineRepository medicineRepository;
    private final AmountUnitRepository amountUnitRepository;
    private final TypeRepository typeRepository;
    Sort sort = Sort.by("title").ascending();

    public Medicine findById(Long id) {
        return medicineRepository.findById(id).get();
    }
    public List<Medicine> findAll(){
        return medicineRepository.findAll(sort);
    }

    public void addNewMedicine(MedicineDto newMedicineDto){
        Type type=typeRepository.findById(newMedicineDto.getTypeId()).get();
        AmountUnit amountUnit=amountUnitRepository.findById(newMedicineDto.getAmountId()).get();
        Medicine medicine=medicineRepository.findByAmountUnitAndTypeAndTitle(amountUnit,type, newMedicineDto.getTitle());
        if (medicine==null){
            medicine=new Medicine();
            medicine.setId(0l);
            medicine.setType(type);
            medicine.setAmountUnit(amountUnit);
            medicine.setTitle(newMedicineDto.getTitle());
            medicine.setAmount(newMedicineDto.getAmount());
            medicineRepository.save(medicine);
        }
    }

    public void editMedicine(MedicineDto medicineDto){
        Medicine medicine = medicineRepository.findById(medicineDto.getId()).get();
        Type type = typeRepository.findById(medicineDto.getTypeId()).get();
        AmountUnit amountUnit = amountUnitRepository.findById(medicineDto.getAmountId()).get();
        medicine.setTitle(medicineDto.getTitle());
        medicine.setType(type);
        medicine.setAmountUnit(amountUnit);
        medicine.setAmount(medicineDto.getAmount());
        medicineRepository.save(medicine);
    }

    public void removeMedicine (Long id){
        medicineRepository.deleteById(id);
    }
}
