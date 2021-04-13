package com.jm.students.repository;

import com.jm.students.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl extends AbstractEntityRepositoryImpl<User> implements UserRepository {

}
