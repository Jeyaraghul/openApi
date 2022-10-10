package com.zaga.OpenAPI.controllers;

import com.zaga.OpenAPI.models.ToDoItem;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetToDoItemById {
    @GetMapping(value = "/todos/{toDoItemId}")
    @Operation(
            tags ={"ToDo Item"}
    )
    public ResponseEntity<Object> getToDoItemById(@PathVariable String toDoItemId) {
        return ResponseEntity.ok().body(new ToDoItem(toDoItemId,"Item 1","Item 1 description",false));
    }
}
