package com.zaga.OpenAPI.controllers;

import com.zaga.OpenAPI.models.ToDoItem;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateToDoItem {
    @PutMapping(value = "/todos/{toDoItemId}")
    @Operation(

            tags = {"ToDo Item"},
            operationId = "updateToDoItem",
            summary = "This is the summary",
            description = "This is the description",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "This is the request Body description",
            content = @Content(schema = @Schema(implementation = ToDoItem.class))),
            parameters = {@Parameter(name = "toDoItemId",description = "This is a path variable ",example="545",
            in = ParameterIn.PATH)},
            externalDocs = @ExternalDocumentation(url="http://oneone.com",description ="for more info click this link"),
            responses ={@ApiResponse(responseCode ="200" , content = @Content(schema = @Schema(implementation=ToDoItem.class),
                        mediaType = MediaType.APPLICATION_JSON_VALUE),

                    description = "Successful Response")  },
            security = {@SecurityRequirement(name = "BearerJWT")}


    )
    public ResponseEntity<Object> updateToDoItem(@PathVariable String toDoItemId,
                                                 @RequestBody ToDoItem toDoItem,
                                                 @CookieValue(required = false) String canEdit,
                                                 @RequestHeader Boolean fromHost,
                                                 @RequestParam Boolean isClient) {

        return ResponseEntity.ok().body(toDoItem);
    }
}
