package ru.home.project.homepharmacy.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.home.project.homepharmacy.dtos.AmountUnitDto;
import ru.home.project.homepharmacy.entities.AmountUnit;
import ru.home.project.homepharmacy.entities.Type;
import ru.home.project.homepharmacy.repositories.AmountUnitRepository;
import ru.home.project.homepharmacy.repositories.TypeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AmountUnitService {
    private final AmountUnitRepository amountUnitRepository;

    public List<AmountUnit> findAll(){
        return amountUnitRepository.findAll();
    }

    public void addNewAmountUnit(AmountUnitDto newAmountUnitDto){
        AmountUnit newAmountUnit;
        newAmountUnit=amountUnitRepository.findAllByTitle(newAmountUnitDto.getTitle());
        if (newAmountUnit==null){
            newAmountUnit=new AmountUnit();
            newAmountUnit.setTitle(newAmountUnitDto.getTitle());
            amountUnitRepository.save(newAmountUnit);
        }
    }
}
