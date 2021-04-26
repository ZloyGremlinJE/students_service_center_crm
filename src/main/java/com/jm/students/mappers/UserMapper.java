package com.jm.students.mappers;


import com.jm.students.DTO.UserDTO;
import com.jm.students.model.User;
import com.jm.students.model.organization.AbstractOrganization;
import com.jm.students.service.AbstractOrganizationService;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "userDTO.id", target = "id")
    @Mapping(source = "userDTO.firstName", target = "firstName")
    @Mapping(source = "userDTO.lastName", target = "lastName")
    @Mapping(source = "userDTO.role", target = "role")
    @Mapping(source = "userDTO.username", target = "email")
    User toUser(UserDTO userDTO, AbstractOrganizationService abstractOrganizationService);



    @AfterMapping
    default void updateResult(@MappingTarget User user,
                              UserDTO userDTO, AbstractOrganizationService abstractOrganizationService) {
        AbstractOrganization organization = abstractOrganizationService.findById(userDTO.getOrganizationId());
        user.setOrganization(organization);
    }
}
