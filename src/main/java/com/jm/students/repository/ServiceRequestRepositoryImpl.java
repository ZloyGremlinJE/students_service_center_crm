package com.jm.students.repository;

import com.jm.students.model.ServiceRequest;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ServiceRequestRepositoryImpl implements ServiceRequestRepository {

    @PersistenceContext
    private final EntityManager em;

    public ServiceRequestRepositoryImpl(EntityManager entityManager) {
        em = entityManager;
    }

    @Override
    public List<ServiceRequest> getAllServiceRequests() {
        return em.createQuery("from ServiceRequest", ServiceRequest.class).getResultList();
    }

    @Override
    public void saveServiceRequest(ServiceRequest request) {
        request.setCustomer(em.merge(request.getCustomer()));
        em.persist(request);
    }

    @Override
    public void updateServiceRequest(ServiceRequest request) {
        em.merge(request);
    }

    @Override
    public void deleteServiceRequest(ServiceRequest request) {
        em.remove(em.contains(request) ? request : em.merge(request));
    }

    @Override
    public ServiceRequest getServiceRequestById(long id) {
        return em.find(ServiceRequest.class, id);
    }
}
