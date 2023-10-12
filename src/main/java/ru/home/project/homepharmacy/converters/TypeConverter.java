package ru.home.project.homepharmacy.converters;

import org.springframework.stereotype.Component;
import ru.home.project.homepharmacy.dtos.TypeDto;
import ru.home.project.homepharmacy.entities.Type;


@Component
public class TypeConverter {
    public TypeDto entityToDto(Type type){
        TypeDto typeDto=TypeDto.builder()
                .id(type.getId())
                .title(type.getTitle())
                .build();
        return typeDto;
    }
}
