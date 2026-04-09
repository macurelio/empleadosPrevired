package com.previred.empleados.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.previred.empleados.controller.EmpleadoServlet;
import com.previred.empleados.service.EmpleadoService;

@Configuration
public class ServletConfig {
    
    /**
     * Bean compartido de ObjectMapper para serialización/deserialización JSON.
     */
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        return mapper;
    }

    /**
     * Registra el EmpleadoServlet en la ruta /api/empleados/*.
     * Esto es equivalente a usar @WebServlet, pero gestionado por Spring Boot.
     */
    @Bean
    public ServletRegistrationBean<EmpleadoServlet> empleadoServletRegistration(
            EmpleadoService empleadoService,
            ObjectMapper objectMapper) {

        EmpleadoServlet servlet = new EmpleadoServlet(empleadoService, objectMapper);

        ServletRegistrationBean<EmpleadoServlet> registration =
                new ServletRegistrationBean<>(servlet, "/api/empleados/*");

        registration.setName("empleadoServlet");
        registration.setLoadOnStartup(1);

        return registration;
    }
    
}
