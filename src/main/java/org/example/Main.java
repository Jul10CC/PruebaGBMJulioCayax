package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Debes indicar el modo: insert o read");
            return;
        }

        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("src/main/resources/app.properties"));

            String archivoExport = prop.getProperty("empleados.export.filename");

            switch (args[0].toLowerCase()) {
                case "insert":
                    InsertarEmpleados.main(null);
                    break;
                case "read":
                    LeerEmpleados.exportarEmpleados(archivoExport);
                    break;
                default:
                    System.out.println("Modo no reconocido. Usa: insert o read");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
