package org.example;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Debes indicar el modo: insert o read");
            return;
        }

        switch (args[0].toLowerCase()) {
            case "insert":
                InsertarEmpleados.main(null);
                break;
            case "read":
                LeerEmpleados.exportarEmpleados("empleados");
                break;
            default:
                System.out.println("Modo no reconocido. Usa: insert o read");
        }
    }
}
