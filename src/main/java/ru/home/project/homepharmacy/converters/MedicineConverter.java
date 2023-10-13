package ru.home.project.homepharmacy.converters;

import org.springframework.stereotype.Component;
import ru.home.project.homepharmacy.dtos.MedicineDto;
import ru.home.project.homepharmacy.dtos.TypeDto;
import ru.home.project.homepharmacy.entities.Medicine;
import ru.home.project.homepharmacy.entities.Type;

@Component
public class MedicineConverter {
    public MedicineDto entityToDto(Medicine medicine) {
        MedicineDto medicineDto = MedicineDto.builder()
                .id(medicine.getId())
                .title(medicine.getTitle())
                .typeId(medicine.getType().getId())
                .amountId(medicine.getAmountUnit().getId())
                .amount(medicine.getAmount())
                .build();
        return medicineDto;
    }
}
