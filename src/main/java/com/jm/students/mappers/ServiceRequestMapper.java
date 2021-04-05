package com.jm.students.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServiceRequestMapper {

    ServiceRequestMapper SERVICE_REQUEST_MAPPER = Mappers.getMapper(ServiceRequestMapper.class);
}
