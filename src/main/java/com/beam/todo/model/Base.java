package com.beam.todo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
public class Base {

    @Id
    String id = UUID.randomUUID().toString();
}
