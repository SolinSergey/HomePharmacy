package ru.home.project.homepharmacy.dtos;

import lombok.Data;

@Data
public class MedicineDto {
    private String title;
    private long typeId;
    private int amount;
    private long amountId;
}
