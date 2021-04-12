package com.jm.students.repository;

import com.jm.students.model.User;

import java.util.List;

public interface UserRepository {
    List<User> getAllUsers();
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    User getUserById(Long id);
    User findUserByEmail(String email);
}
