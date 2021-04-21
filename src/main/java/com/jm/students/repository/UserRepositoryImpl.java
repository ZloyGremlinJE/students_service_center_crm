package com.jm.students.repository;

import com.jm.students.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl extends AbstractEntityRepositoryImpl<User> implements UserRepository {
    @Override
    public User getUserByTelegramId(String telegramChatId) {
        return (User) entityManager.createQuery("select u from User u where u.telegramChatId=:telegramChatId")
                .setParameter("telegramChatId", telegramChatId)
                .getSingleResult();
    }
}
