package com.jm.students.service;

import com.jm.students.model.User;

import java.util.List;

public interface UserService extends AbstractEntityService<User> {
    String passwordGenerator();
    User findUserByEmail(String email);
    User getUserByTelegramId(String telegramChatId);
    List<User> findByIsDisabled(boolean isDisabled);
}
