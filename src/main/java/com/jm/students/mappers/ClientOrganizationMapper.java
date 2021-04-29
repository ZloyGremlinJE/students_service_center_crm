package com.jm.students.mappers;

import com.jm.students.DTO.ClientOrganizationDTO;
import com.jm.students.model.organization.ClientOrganization;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientOrganizationMapper {
    ClientOrganizationMapper CLIENT_ORGANIZATION_MAPPER = Mappers.getMapper(ClientOrganizationMapper.class);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    ClientOrganizationDTO toClientOrganizationDto(ClientOrganization clientOrganization);
}
