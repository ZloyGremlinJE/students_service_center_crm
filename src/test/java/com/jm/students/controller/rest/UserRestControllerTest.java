package com.jm.students.controller.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jm.students.DTO.UserDTO;
import com.jm.students.mappers.UserMapper;
import com.jm.students.model.Role;
import com.jm.students.model.User;
import com.jm.students.service.AbstractOrganizationService;
import com.jm.students.service.UserService;
import com.jm.students.service.util.EmailService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class UserRestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;
    @MockBean
    private EmailService emailService;
    @MockBean
    private AbstractOrganizationService abstractOrganizationService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void addUserResponseShouldBeOk() throws Exception {
        UserDTO userDTOFirst = new UserDTO();
        userDTOFirst.setFirstName("Elon");
        userDTOFirst.setLastName("Mask");
        userDTOFirst.setUsername("mask@gmail.com");
        userDTOFirst.setRole(Role.ENGINEER);
        userDTOFirst.setOrganizationId(2L);


        mockMvc.perform(post("/api/users")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(userDTOFirst)))
                .andExpect(status().isOk());
    }

    @Test
    void addUserResponseNotShouldBeOk() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName("Bill");
        userDTO.setLastName("Gates");
        userDTO.setUsername("bill@gmail");

        UserDTO userDTONull = new UserDTO();

        UserDTO userDTOEmpty = new UserDTO();
        userDTOEmpty.setFirstName(" ");
        userDTOEmpty.setLastName(" ");
        userDTOEmpty.setUsername(" ");

        mockMvc.perform(post("/api/users")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(userDTO)))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/api/users")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(userDTONull)))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/api/users")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(userDTOEmpty)))
                .andExpect(status().isBadRequest());

    }

    @Test
    void addUserResponseShouldBeImUsed() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName("Федор");
        userDTO.setLastName("Черенков");
        userDTO.setUsername("cherenok@gmail.ru");

        Mockito.doReturn(new User()).when(userService).findUserByEmail(userDTO.getUsername());

        mockMvc.perform(post("/api/users")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(userDTO)))
                .andExpect(status().isImUsed());
    }

}