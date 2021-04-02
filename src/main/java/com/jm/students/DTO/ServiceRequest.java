package com.jm.students.DTO;

import com.jm.students.model.RequestType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Data
public class ServiceRequest {
    private long id;
    private String vehicleNumber;
    private LocalDate dateOfCreate;
    private RequestType requestType;
    private String problem;
    private ClientEmployeeDTO customer;
    private List<EquipmentOrderDTO> orders;
}
