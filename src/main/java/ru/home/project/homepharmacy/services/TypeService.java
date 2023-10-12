package ru.home.project.homepharmacy.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.home.project.homepharmacy.dtos.TypeDto;
import ru.home.project.homepharmacy.entities.Type;
import ru.home.project.homepharmacy.repositories.TypeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeService {
    private final TypeRepository typeRepository;

    public Type findById(Long id){
        return typeRepository.findById(id).get();
    }
    public List<Type> findAll(){
        return typeRepository.findAll();
    }

    public void addNewType(TypeDto newTypeDto){
        Type newType;
        newType=typeRepository.findAllByTitle(newTypeDto.getTitle());
        if (newType==null){
            newType=new Type();
            newType.setTitle(newTypeDto.getTitle());
            typeRepository.save(newType);
        }
    }

    public void editType(TypeDto editTypeDto){
        Type type = typeRepository.findById(editTypeDto.getId()).get();
        type.setTitle(editTypeDto.getTitle());
        typeRepository.save(type);
    }
    public void removeType (Long id){
        typeRepository.deleteById(id);
    }
}
