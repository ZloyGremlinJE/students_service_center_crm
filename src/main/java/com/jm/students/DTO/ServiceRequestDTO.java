package com.jm.students.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ServiceRequestDTO {
    private Long id;
    private String vehicleNumber;
    private LocalDate dateOfCreate;
    private RequestTypeDTO requestTypeDTO;
    private String problem;
    private ClientEmployeeDTO customer;
    private List<EquipmentOrderDTO> orders;
}
