package com.beam.todo.repository;

import com.beam.todo.model.todo.Todo;
import com.beam.todo.model.user.User;
import com.mongodb.client.result.DeleteResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void setUser() {
        User user = new User()
                .setUserName("BillGates")
                .setPassword("microsoft");

        userRepository.save(user);
    }

    @Test
    public void findUserById() {
        Optional<User> user = userRepository.findById("0e8174e9-2e34-4cba-9b33-6841bdaf3c34");
    }

    @Test
    public void findAllUsers() {
        userRepository.findAll();
    }

    @Test
    public void deleteUser(User user) {

        userRepository.delete(user);
    }

    @Test
    public void deleteUserById(String id) {
        DeleteResult deleteResult = mongoTemplate.remove(Query.query(Criteria.where("_id").is(id)), "User");
        assertEquals(1, deleteResult.getDeletedCount());
    }

    @Test
    public void getUserByPassword() {

        List<User> userList = userRepository.findByPassword("linux");
    }

    @Test
    public void setTodoToUser() {
        Optional<Todo> todo = todoRepository.findById("d7a251df-0c4d-423b-a76d-77870805ebf8");
        Optional<User> user = userRepository.findById("d3f72d68-d8f5-4263-b342-7e23eef579b1");

        user.get().setTodoList(Arrays.asList(todo.get()));

        userRepository.save(user.get());
    }

}
