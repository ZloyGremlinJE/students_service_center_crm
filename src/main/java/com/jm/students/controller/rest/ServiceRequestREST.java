package com.jm.students.controller.rest;

import com.jm.students.DTO.ServiceRequestDTO;
import com.jm.students.mappers.ServiceRequestMapper;
import com.jm.students.model.ServiceRequest;
import com.jm.students.service.ServiceRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("serviceRequests")
public class ServiceRequestREST {
    private final ServiceRequestService serviceRequestService;
    private final ServiceRequestMapper serviceRequestMapper;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ServiceRequestDTO getOneServiceRequest(@PathVariable Long id) {
        return serviceRequestMapper.toServiceRequestDto(serviceRequestService.getServiceRequestById(id));
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<ServiceRequestDTO> getAllServiceRequests() {
        List<ServiceRequest> listOfRequests = serviceRequestService.getAllServiceRequests();
        List<ServiceRequestDTO> listOfRequestsDTO = new ArrayList<>();
        for (ServiceRequest request : listOfRequests) {
            listOfRequestsDTO.add(serviceRequestMapper.toServiceRequestDto(request));
        }
        return listOfRequestsDTO;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void addServiceRequest(@RequestBody ServiceRequest serviceRequest) {
        serviceRequestService.saveServiceRequest(serviceRequest);
    }

    @PutMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public void updateServiceRequest(@RequestBody ServiceRequest serviceRequest) {
        serviceRequestService.updateServiceRequest(serviceRequest);
    }

}
