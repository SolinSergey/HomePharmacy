package ru.home.project.homepharmacy.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AmountUnitDto {
    private Long id;
    private String title;
}
