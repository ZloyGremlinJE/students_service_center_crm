package com.jm.students.service;

import com.jm.students.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    User getUserById(Long id);
public interface UserService extends AbstractEntityService<User> {
}
