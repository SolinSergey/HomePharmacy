package ru.home.project.homepharmacy.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.home.project.homepharmacy.dtos.AmountUnitDto;
import ru.home.project.homepharmacy.dtos.TypeDto;
import ru.home.project.homepharmacy.entities.AmountUnit;
import ru.home.project.homepharmacy.entities.Type;
import ru.home.project.homepharmacy.repositories.AmountUnitRepository;
import ru.home.project.homepharmacy.repositories.TypeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AmountUnitService {
    private final AmountUnitRepository amountUnitRepository;
    Sort sort = Sort.by("title").ascending();
    public AmountUnit findById(Long id) {
        return amountUnitRepository.findById(id).get();
    }

    public List<AmountUnit> findAll() {
        return amountUnitRepository.findAll(sort);
    }

    public void addNewAmountUnit(AmountUnitDto newAmountUnitDto) {
        AmountUnit newAmountUnit;
        newAmountUnit = amountUnitRepository.findAllByTitle(newAmountUnitDto.getTitle());
        if (newAmountUnit == null) {
            newAmountUnit = new AmountUnit();
            newAmountUnit.setTitle(newAmountUnitDto.getTitle());
            amountUnitRepository.save(newAmountUnit);
        }
    }

    public void editAmountUnit(AmountUnitDto editAmountUnitDto) {
        AmountUnit amountUnit = amountUnitRepository.findById(editAmountUnitDto.getId()).get();
        amountUnit.setTitle(editAmountUnitDto.getTitle());
        amountUnitRepository.save(amountUnit);
    }

    public void removeAmountUnit (Long id){
        amountUnitRepository.deleteById(id);
    }
}
