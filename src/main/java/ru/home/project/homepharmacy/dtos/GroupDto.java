package ru.home.project.homepharmacy.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GroupDto {
    private Long id;
    private String title;
}
