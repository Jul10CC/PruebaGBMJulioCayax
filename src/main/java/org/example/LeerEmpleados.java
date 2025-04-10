package org.example;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LeerEmpleados {

    public static void exportarEmpleados(String nombreBaseArchivo) {
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQLQueries.SELECT_EMPLEADOS)) {

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
            String nombreArchivo = nombreBaseArchivo + "_" + dtf.format(LocalDateTime.now()) + ".csv";

            try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
                ResultSetMetaData meta = rs.getMetaData();
                int columnas = meta.getColumnCount();

                for (int i = 1; i <= columnas; i++) {
                    writer.print(meta.getColumnName(i));
                    if (i < columnas) writer.print(";");
                }
                writer.println();

                while (rs.next()) {
                    for (int i = 1; i <= columnas; i++) {
                        writer.print(rs.getString(i));
                        if (i < columnas) writer.print(";");
                    }
                    writer.println();
                }

                System.out.println("Datos exportados a: " + nombreArchivo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
