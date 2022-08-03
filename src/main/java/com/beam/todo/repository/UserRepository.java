package com.beam.todo.repository;

import com.beam.todo.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByPassword(String password);
}
