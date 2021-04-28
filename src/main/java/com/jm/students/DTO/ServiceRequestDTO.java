package com.jm.students.DTO;

import com.jm.students.model.RequestType;
import com.jm.students.model.StatusRequestType;
import com.jm.students.model.organization.ClientOrganization;
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
    private ClientOrganizationDTO organization;
    private List<EquipmentOrderDTO> orders;
    private StatusRequestType statusRequestType;
}
