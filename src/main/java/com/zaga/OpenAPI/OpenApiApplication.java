package com.zaga.OpenAPI;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info =@Info(title = "ToDo Items",description = "This application to do  application",version ="1.0.0" ),
        servers = {@Server(url ="http://localhost:8080" ,description =" This server is for testing locally" ),
				@Server(url ="http://oneolne.com" ,description =" This server is for production" )},
		tags = {@Tag(name = "ToDo Item",description = " These Apis are for todoitem data model ")}
)
@SecurityScheme( name = "BearerJWT", type = SecuritySchemeType.HTTP, scheme ="bearer", bearerFormat = "JWT",
description = "Bearer Token for the project .")
public class OpenApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenApiApplication.class, args);
	}

}
