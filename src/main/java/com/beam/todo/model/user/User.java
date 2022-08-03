package com.beam.todo.model.user;

import com.beam.todo.model.Base;
import com.beam.todo.model.todo.Todo;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "User") // -> Tablo Adı
@Data // -> Lombok(auto*(get, set, constructor))
@TypeAlias("User") // -> Db Class name
@Accessors(chain = true) // -> zincirleme*(set, get)
public class User extends Base {

    private String userName;
    private String password;
    private List<Todo> todoList = null;
    private UserStatus status = UserStatus.CREATED;

}
