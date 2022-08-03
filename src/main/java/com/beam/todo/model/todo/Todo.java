package com.beam.todo.model.todo;

import com.beam.todo.model.Base;
import com.beam.todo.model.user.User;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@TypeAlias("Todo")
@Document(collection = "Todo")
@Accessors(chain = true)
public class Todo extends Base {

    private String title;
    private String content;
    private Date createDate = new Date();
    private TodoStatus status = TodoStatus.CREATED;
}

