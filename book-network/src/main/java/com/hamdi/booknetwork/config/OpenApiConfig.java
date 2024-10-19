package com.hamdi.booknetwork.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Hamza",
                        email = "h_hamdi@etu.enset-media.ac.ma",
                        url = "https://www.linkedin.com/in/hamzahamdi-it"
                ),
                description = "OpenApi documentation for Spring security",
                title = "OpenApi specification - Hamza",
                version = "1.0",
                license = @License(
                        name = "License name",
                        url = "url"
                ),
                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080/api/v1"

                ),
                @Server(
                        description = "Prod ENV",
                        url = "http://localhost:8080/api/v1"

                ),


        },
        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }
)
@SecurityScheme(name = "bearerAuth",
description = "JWT auth description",
scheme = "bearer",
type = SecuritySchemeType.HTTP,
bearerFormat = "JWT",
in = SecuritySchemeIn.HEADER)
public class OpenApiConfig {
}
