package com.jm.students.repository.reports_repository;

import com.jm.students.DTO.reports.ServiceRequestInfoDTO;
import com.jm.students.repository.pagination.PaginationRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;

@Repository(value = "PaginationServiceRequestInfoRepository")
public class PaginationServiceRequestInfoRepositoryImpl implements PaginationRepository<ServiceRequestInfoDTO> {

    @PersistenceContext
    private EntityManager em;

    @Override
    @SuppressWarnings(value = "unchecked")
    public List<ServiceRequestInfoDTO> getItems(Map<String, Object> parameters) {

        int page = (int)parameters.get("page");
        int size = (int)parameters.get("size");
        List<Long> serviceRequestsIds =(List<Long>) em.createQuery(
                "select sr.id from ServiceRequest sr")
                .setFirstResult(page*size-size)
                .setMaxResults(size)
                .getResultList();

        return (List<ServiceRequestInfoDTO>) em.createQuery(
                "select new com.jm.students.DTO.reports.ServiceRequestInfoDTO(sr.id, sr.dateOfCreate, sr.problem, sr.service_manager.id) " +
                        "from ServiceRequest sr " +
                        "where sr.id in (:ids) " +
                        "order by sr.id")
                .setParameter("ids", serviceRequestsIds)
                .getResultList();
    }

    @Override
    public int getCount(Map<String, Object> parameters) {
        return (int)(long) em.createQuery("select count (sr) from ServiceRequest sr").getSingleResult();
    }
}
