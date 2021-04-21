package com.jm.students.repository;

import com.jm.students.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class UserRepositoryImpl extends AbstractEntityRepositoryImpl<User> implements UserRepository {

    @PersistenceContext
    private final EntityManager em;

    public UserRepositoryImpl(EntityManager entityManager) {
        em = entityManager;
    }

    @Override
    public void save(User user) {
        user.setOrganization(em.merge(user.getOrganization()));
        super.save(user);
    }

    @Override
    public User findUserByEmail(String email) {

        Query query = em.createQuery("select u from User u where u.email = :userEmail");
        query.setParameter("userEmail", email);

        return (User) query.getSingleResult();
    }
}
