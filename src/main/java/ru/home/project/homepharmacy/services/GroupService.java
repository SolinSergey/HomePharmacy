package ru.home.project.homepharmacy.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.home.project.homepharmacy.dtos.GroupDto;
import ru.home.project.homepharmacy.dtos.TypeDto;
import ru.home.project.homepharmacy.entities.Group;
import ru.home.project.homepharmacy.entities.Type;
import ru.home.project.homepharmacy.repositories.GroupRepository;
import ru.home.project.homepharmacy.repositories.TypeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    Sort sort = Sort.by("title").ascending();

    public Group findById(Long id) {
        return groupRepository.findById(id).get();
    }

    public List<Group> findAll() {
        return groupRepository.findAll(sort);
    }

    public void addNewGroup(GroupDto newGroupDto) {
        Group newGroup;
        newGroup = groupRepository.findAllByTitle(newGroupDto.getTitle());
        if (newGroup == null) {
            newGroup = new Group();
            newGroup.setTitle(newGroupDto.getTitle());
            groupRepository.save(newGroup);
        }
    }

    public void editGroup(GroupDto editGroupDto) {
        Group group = groupRepository.findById(editGroupDto.getId()).get();
        group.setTitle(editGroupDto.getTitle());
        groupRepository.save(group);
    }

    public void removeType(Long id) {
        groupRepository.deleteById(id);
    }
}
