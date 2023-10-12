package ru.home.project.homepharmacy.services;

import lombok.RequiredArgsConstructor;
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

    public List<Medicine> findAll(){
        return medicineRepository.findAll();
    }

    public void addNewMedicine(MedicineDto newMedicineDto){
        Type type=typeRepository.findById(newMedicineDto.getTypeId()).get();
        AmountUnit amountUnit=amountUnitRepository.findById(newMedicineDto.getAmountId()).get();
        Medicine medicine=medicineRepository.findByAmountUnitAndTypeAndTitle(amountUnit,type, newMedicineDto.getTitle());
        if (medicine==null){
            medicine=new Medicine();
            medicine.setId(0);
            medicine.setType(type);
            medicine.setAmountUnit(amountUnit);
            medicine.setTitle(newMedicineDto.getTitle());
            medicine.setAmount(newMedicineDto.getAmount());
            medicineRepository.save(medicine);
        }
    }
}
