package com.jm.students.service.reportsService;

import com.jm.students.DTO.pagination.PageDTO;
import com.jm.students.DTO.reports.ServiceRequestInfoDTO;

public interface ReportsService {
    PageDTO<ServiceRequestInfoDTO> getPageAllServiceRequestInfo(int page, int size);
}
