package com.jm.students.repository;

import com.jm.students.model.EquipmentOrder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EquipmentOrderRepositoryImpl implements EquipmentOrderRepository {

    @PersistenceContext
    private final EntityManager em;

    public EquipmentOrderRepositoryImpl(EntityManager entityManager) {
        em = entityManager;
    }

    @Override
    public List<EquipmentOrder> getAllEquipmentOrders() {
        return em.createQuery("from EquipmentOrder", EquipmentOrder.class).getResultList();
    }

    @Override
    public void saveEquipmentOrder(EquipmentOrder order) {
        em.persist(order);
    }

    @Override
    public void updateEquipmentOrder(EquipmentOrder order) {
        em.merge(order);
    }

    @Override
    public void deleteEquipmentOrder(EquipmentOrder order) {
        em.remove(em.contains(order) ? order : em.merge(order));
    }

    @Override
    public EquipmentOrder getEquipmentOrderById(long id) {
        return em.find(EquipmentOrder.class, id);
    }
}
