package ru.home.project.homepharmacy.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.home.project.homepharmacy.converters.GroupConverter;
import ru.home.project.homepharmacy.converters.TypeConverter;
import ru.home.project.homepharmacy.dtos.GroupDto;
import ru.home.project.homepharmacy.dtos.TypeDto;
import ru.home.project.homepharmacy.entities.Group;
import ru.home.project.homepharmacy.entities.Type;
import ru.home.project.homepharmacy.services.GroupService;
import ru.home.project.homepharmacy.services.TypeService;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("group")
public class GroupController {
    private final GroupService groupService;
    private final GroupConverter groupConverter;

    @GetMapping("listAll")
    public String listAllGroups(Model model) {
        List<Group> groupList = groupService.findAll();
        model.addAttribute("groupList", groupList);
        return "group/viewAllGroups";
    }

    @GetMapping("addNewGroup")
    public String addNewGroup(Model model) {
        GroupDto newGroupDto = GroupDto.builder().build();
        model.addAttribute("newGroup", newGroupDto);
        return "group/formAddGroup";
    }

    @PostMapping("addNewGroup")
    public String addNewGroup(@ModelAttribute("newGroup") GroupDto newGroupDto, Model model) {
        groupService.addNewGroup(newGroupDto);
        return "redirect:/group/listAll";
    }

    @GetMapping("editGroup")
    public String editById(@RequestParam Long id, Model model) {
        model.addAttribute("editGroup", groupConverter.entityToDto(groupService.findById(id)));
        return "group/formEditGroup";
    }

    @PostMapping("editGroup")
    public String editById(@ModelAttribute("editGroup") GroupDto editGroupDto, Model model) {
        groupService.editGroup(editGroupDto);
        return "redirect:/group/listAll";
    }

    @GetMapping("removeGroup")
    public String removeById(@RequestParam Long id, Model model) {
        groupService.removeType(id);
        return "redirect:/group/listAll";
    }

}
