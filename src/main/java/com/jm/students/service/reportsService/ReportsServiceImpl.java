package com.jm.students.service.reportsService;

import com.jm.students.DTO.pagination.PageDTO;
import com.jm.students.DTO.reports.ServiceRequestInfoDTO;
import com.jm.students.service.pagination.PaginationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class ReportsServiceImpl implements ReportsService {

    private final PaginationService<ServiceRequestInfoDTO,Object> paginationService;

    @Override
    public PageDTO<ServiceRequestInfoDTO> getPageAllServiceRequestInfo(int page, int size) {
        return paginationService.getPageDTO("PaginationServiceRequestInfoRepository",setPaginationParameters(page, size));
    }

    private Map<String, Object> setPaginationParameters(int page, int size) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("page", page);
        parameters.put("size", size);
        return parameters;
    }
}
