package com.jm.students.service;

import com.jm.students.model.User;
import com.jm.students.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl extends AbstractEntityServiceImpl<User>  implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByTelegramId(String telegramChatId) {
        return userRepository.getUserByTelegramId(telegramChatId);
    }
}

