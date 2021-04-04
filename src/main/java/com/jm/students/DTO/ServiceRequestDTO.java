package com.jm.students.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Data
public class ServiceRequestDTO {
    private Long id;
    private String vehicleNumber;
    private LocalDate dateOfCreate;
    private RequestTypeDTO requestTypeDTO;
    private String problem;
    private ClientEmployeeDTO customer;
    private List<EquipmentOrderDTO> orders;
}
