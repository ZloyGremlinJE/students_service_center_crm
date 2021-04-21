package com.jm.students.service;

import com.jm.students.model.User;
import com.jm.students.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl extends AbstractEntityServiceImpl<User>  implements UserService {

    private final UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByTelegramId(String telegramChatId) {
        return (User) entityManager.createQuery("select u from User u where u.telegramChatId=:telegramChatId")
                .setParameter("telegramChatId", telegramChatId)
                .getSingleResult();
    }

}

