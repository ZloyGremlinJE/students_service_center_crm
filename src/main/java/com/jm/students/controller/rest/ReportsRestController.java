package com.jm.students.controller.rest;

import com.jm.students.DTO.pagination.PageDTO;
import com.jm.students.DTO.reports.ServiceRequestInfoDTO;
import com.jm.students.service.reportsService.ReportsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reportAPI")
public class ReportsRestController {
    private static final int MAX_ITEMS_ON_PAGE = 100;
    private final ReportsService reportsService;

    @GetMapping("/serviceRequestsInfo")
    public ResponseEntity<?> getServiceRequestsInfo(@RequestParam("page") int page, @RequestParam("size") int size){
        if (page <= 0 || size <= 0 || size > MAX_ITEMS_ON_PAGE) {
            return ResponseEntity.badRequest().body("Номер страницы и размер должны быть " +
                    "положительными. Максимальное количество записей на странице " + MAX_ITEMS_ON_PAGE);
        }
        PageDTO<ServiceRequestInfoDTO> resultPage = reportsService.getPageAllServiceRequestInfo(page, size);

        return  ResponseEntity.ok(resultPage);
    }
}
