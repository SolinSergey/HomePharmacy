package ru.home.project.homepharmacy.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MedicineDto {
    Long id;
    private String title;
    private Long typeId;
    private Integer amount;
    private Long amountId;
    private Long groupId;
}
