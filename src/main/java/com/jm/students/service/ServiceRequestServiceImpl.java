package com.jm.students.service;

import com.jm.students.enums.StatusRequestType;
import com.jm.students.model.ServiceRequest;
import com.jm.students.repository.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ServiceRequestServiceImpl implements ServiceRequestService {

    private final ServiceRequestRepository requestRepository;

    @Autowired
    public ServiceRequestServiceImpl(ServiceRequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public List<ServiceRequest> getAllServiceRequests() {
        return requestRepository.getAllServiceRequests();
    }

    @Override
    public void saveServiceRequest(ServiceRequest request) {
        requestRepository.saveServiceRequest(request);
    }

    @Override
    public void updateServiceRequest(ServiceRequest request) {
        requestRepository.updateServiceRequest(request);
    }

    @Override
    public void deleteServiceRequest(ServiceRequest request) {
        requestRepository.deleteServiceRequest(request);
    }

    @Override
    public ServiceRequest getServiceRequestById(long id) {
        return requestRepository.getServiceRequestById(id);
    }

    /**
     * Метод находит заявку по {@param id},
     * устанавливает этой заявке новый статус {@param statusRequestType}
     * и изменяет заявку в базе
     * @param id идентификатор заявки
     * @param statusRequestType новый статус заявки
     */
    @Override
    public void updateStatusRequestType(long id, StatusRequestType statusRequestType) {
        ServiceRequest serviceRequest = getServiceRequestById(id);
        serviceRequest.setStatusRequestType(statusRequestType);
        updateServiceRequest(serviceRequest);
    }
}
