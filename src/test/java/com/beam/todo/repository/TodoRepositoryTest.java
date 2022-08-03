package com.beam.todo.repository;

import com.beam.todo.model.todo.Todo;
import com.beam.todo.model.todo.TodoStatus;
import com.beam.todo.model.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class TodoRepositoryTest {
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void setTodo() {
        Todo todo = new Todo()
                .setTitle("FIRST DUTY")
                .setContent("GO TO SPORT");
        todoRepository.save(todo);
    }

    @Test
    public void getTodos() {
        List<Todo> todoList = todoRepository.findAll();
    }

    @Test
    public void getTodoById() {
        Todo todo = todoRepository.findById("520bce3c-1322-42cd-bff2-89bc5b8946fe").orElse(null);
    }

    @Test
    public void deleteTodoById() {
        todoRepository.deleteById("356716f5-ab30-46cb-8783-69dcbaa4fdae");
    }

    @Test
    public void findTodoByTitle(){
        List<Todo> todoList = todoRepository.findByTitle("Selam");
    }
}
