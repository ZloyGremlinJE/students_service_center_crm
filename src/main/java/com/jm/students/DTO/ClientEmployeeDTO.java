package com.jm.students.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class ClientEmployeeDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private List<ServiceRequestDTO> requests;
}
