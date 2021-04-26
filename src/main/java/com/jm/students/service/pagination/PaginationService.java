package com.jm.students.service.pagination;

import com.jm.students.DTO.pagination.PageDTO;

import java.util.Map;

public interface PaginationService<T, V> {
    PageDTO<T> getPageDTO(String methodName, Map<String, Object> parameters);
}
