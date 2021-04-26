package com.jm.students.DTO;

import com.jm.students.model.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class UserDTO {
    private Long id;

    @NotBlank(message = "UNCORRECT FIRST NAME")
    private String firstName;
    @NotBlank(message = "UNCORRECT LAST NAME")
    private String lastName;

    @Email(message = "UNCORRECT EMAIL", regexp = "\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}")
    @NotBlank(message = "UNCORRECT EMAIL")
    private String username;
    private String phoneNumber;
    private Role role;
    private List<ServiceRequestDTO> requests;
    private Long organizationId;
}
