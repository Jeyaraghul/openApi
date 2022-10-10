package com.zaga.OpenAPI.controllers;

import com.zaga.OpenAPI.models.ToDoItem;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateToDoItem {
    @PostMapping(value = "/todos")
    @Operation(
            tags = {"ToDo Item"}
    )
    public ResponseEntity<Object> createToDoItem(@RequestBody ToDoItem toDoItem) {
        return ResponseEntity.ok().body(toDoItem);
    }
}
