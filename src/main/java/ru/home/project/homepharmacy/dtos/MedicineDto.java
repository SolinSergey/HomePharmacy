package ru.home.project.homepharmacy.dtos;

import lombok.Data;

@Data
public class MedicineDto {
    private String title;
    private Long typeId;
    private Integer amount;
    private Long amountId;
}
