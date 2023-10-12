package ru.home.project.homepharmacy.converters;

import org.springframework.stereotype.Component;
import ru.home.project.homepharmacy.dtos.AmountUnitDto;
import ru.home.project.homepharmacy.dtos.TypeDto;
import ru.home.project.homepharmacy.entities.AmountUnit;
import ru.home.project.homepharmacy.entities.Type;


@Component
public class AmountUnitConverter {
    public AmountUnitDto entityToDto(AmountUnit amountUnit){
        AmountUnitDto amountUnitDto=AmountUnitDto.builder()
                .id(amountUnit.getId())
                .title(amountUnit.getTitle())
                .build();
        return amountUnitDto;
    }
}
