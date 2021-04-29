package com.jm.students.DTO;

import com.jm.students.model.RequestType;
import com.jm.students.model.StatusRequestType;
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
    private RequestType requestTypeDTO;
    private String problem;
    private UserDTO customer;
    private UserDTO client_employee;
    private ClientOrganizationDTO clientOrganization;
    private List<EquipmentOrderDTO> orders;
    private StatusRequestType statusRequestType;
}
