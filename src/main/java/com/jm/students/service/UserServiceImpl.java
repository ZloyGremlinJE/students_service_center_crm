package com.jm.students.service;

import com.jm.students.model.User;
import com.jm.students.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findOne(long id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void create(User entity) {
        userRepository.create(entity);
    }

    @Override
    public User update(User entity) {
        return userRepository.update(entity);
    }

    @Override
    public void deleteById(long entityId) {
        userRepository.deleteById(entityId);
    }
}
