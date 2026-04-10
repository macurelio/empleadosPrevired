package com.previred.empleados.dataService;

import java.sql.*;

public class CreateDB {

        // Tu cadena de conexión
        private static final String URL = "jdbc:mysql://localhost:3306/empleadosdb?useSSL=false&serverTimezone=America/Santiago&allowPublicKeyRetrieval=true";
        private static final String USER = "root";
        private static final String PASSWORD = "admin";

        public static void main(String[] args) {
            String sql = "CREATE TABLE IF NOT EXISTS empleados (" +
                    "id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
                    "nombre VARCHAR(100) NOT NULL, " +
                    "apellido VARCHAR(100) NOT NULL, " +
                    "rut VARCHAR(20) NOT NULL UNIQUE, " +
                    "cargo VARCHAR(100) NOT NULL, " +
                    "salario_base DOUBLE NOT NULL, " +
                    "bonificaciones DOUBLE DEFAULT 0, " +
                    "descuentos DOUBLE DEFAULT 0);";

            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement stmt = conn.createStatement()) {

                // Ejecutar el script
                stmt.execute(sql);
                System.out.println("¡Tabla 'empleados' creada exitosamente!");

            } catch (Exception e) {
                System.err.println("Error al conectar o crear la tabla: " + e.getMessage());
            }
        }
    }
