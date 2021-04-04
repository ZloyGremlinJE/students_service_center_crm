package com.jm.students.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EquipmentOrderDTO {
    private Long id;
    private EquipmentTypeDTO equipmentTypeDTO;
    private String equipmentName;
    private Integer price;
    private ServiceRequestDTO request;
}
