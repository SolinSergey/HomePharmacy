package ru.home.project.homepharmacy.converters;

import org.springframework.stereotype.Component;
import ru.home.project.homepharmacy.dtos.GroupDto;
import ru.home.project.homepharmacy.dtos.TypeDto;
import ru.home.project.homepharmacy.entities.Group;
import ru.home.project.homepharmacy.entities.Type;


@Component
public class GroupConverter {
    public GroupDto entityToDto(Group group) {
        GroupDto groupDto = GroupDto.builder()
                .id(group.getId())
                .title(group.getTitle())
                .build();
        return groupDto;
    }
}
