package org.example;

public class SQLQueries {
    public static final String INSERT_EMPLEADO = "INSERT INTO EMPLOYEE (FirstName, LastName, Email, Phone, Department, Position, HireDate, Salary, Status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SELECT_EMPLEADOS = "SELECT * FROM EMPLOYEE";
}
