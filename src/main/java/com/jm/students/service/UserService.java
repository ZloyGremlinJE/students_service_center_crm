package com.jm.students.service;

import com.jm.students.model.User;

public interface UserService extends AbstractEntityService<User> {
    String passwordGenerator();
    User findUserByEmail(String email);
    User getUserByTelegramId(String telegramChatId);
}
