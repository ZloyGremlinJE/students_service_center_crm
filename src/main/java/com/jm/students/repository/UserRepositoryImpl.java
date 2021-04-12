package com.jm.students.repository;

import com.jm.students.model.Role;
import com.jm.students.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private final EntityManager em;

    public UserRepositoryImpl(EntityManager entityManager) {
        em = entityManager;
    }

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        em.persist(user);
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public void deleteUser(User user) {
        em.remove(em.contains(user) ? user : em.merge(user));
    }

    @Override
    public User getUserById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public User findUserByEmail(String email) {

        Query query = em.createQuery("select u from User u where u.email = :userEmail");
        query.setParameter("userEmail", email);

        return (User) query.getSingleResult();
    }
}
