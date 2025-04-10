package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class InsertarEmpleados {

    public static void main(String[] args) {
        try {
            List<Empleado> empleados = new ObjectMapper().readValue(
                    new File("src/main/resources/empleados.json"),
                    new TypeReference<List<Empleado>>() {}
            );

            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement ps = conn.prepareStatement(SQLQueries.INSERT_EMPLEADO)) {

                for (Empleado emp : empleados) {
                    ps.setString(1, emp.firstName);
                    ps.setString(2, emp.lastName);
                    ps.setString(3, emp.email);
                    ps.setString(4, emp.phone);
                    ps.setString(5, emp.department);
                    ps.setString(6, emp.position);
                    ps.setString(7, emp.hireDate);
                    ps.setDouble(8, emp.salary);
                    ps.setString(9, emp.status);
                    ps.addBatch();
                }

                ps.executeBatch();
                System.out.println("Empleados insertados con éxito.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
