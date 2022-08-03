package com.beam.todo.repository;

import com.beam.todo.model.todo.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TodoRepository extends MongoRepository<Todo, String> {

    List<Todo> findByTitle(String title);
}
