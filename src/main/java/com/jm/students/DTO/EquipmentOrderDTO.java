package com.jm.students.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EquipmentOrderDTO {
    private Long id;
    private EquipmentTypeDTO equipmentTypeDTO;
    private String equipmentName;
    private Integer price;
    private ServiceRequestDTO request;
}
