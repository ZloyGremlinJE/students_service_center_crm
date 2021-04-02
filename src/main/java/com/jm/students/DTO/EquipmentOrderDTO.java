package com.jm.students.DTO;

import com.jm.students.model.EquipmentType;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EquipmentOrderDTO {
    private long id;
    private EquipmentType equipmentType;
    private String equipmentName;
    private int price;
    private ServiceRequestDTO request;
}
