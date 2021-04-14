package com.jm.students.service;

import com.jm.students.enums.StatusRequestType;
import com.jm.students.model.ServiceRequest;

import java.util.List;

public interface ServiceRequestService {
    List<ServiceRequest> getAllServiceRequests();
    void saveServiceRequest(ServiceRequest request);
    void updateServiceRequest(ServiceRequest request);
    void deleteServiceRequest(ServiceRequest request);
    ServiceRequest getServiceRequestById(long id);
    void updateStatusRequestType(long id, StatusRequestType statusRequestType);

}
