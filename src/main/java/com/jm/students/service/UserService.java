package com.jm.students.service;

import com.jm.students.model.User;
import java.util.List;

public interface UserService {
    User findOne(long id);

    List<User> findAll();

    void create(User entity);

    User update(User entity);

    void deleteById(long entityId);
}
