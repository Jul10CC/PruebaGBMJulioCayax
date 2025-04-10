README - Proyecto Prueba Técnica GBM - Julio Cayax

Descripción
Este proyecto es una herramienta en Java que permite insertar y leer datos de una base de datos SQL Server. Cuenta con dos modos de ejecución:  
- insert: Inserta empleados desde un archivo empleados.json.
- read: Lee empleados desde la base de datos y los exporta a un archivo .csv.

Requisitos
- Java 8 o superior instalado
- MS SQL Server Express
- Driver JDBC de SQL Server (sqljdbc42.jar)
- Maven para compilar
- Carpeta con el driver: C:\sqljdbc

Configuración

1. Asegúrate de tener una base de datos creada con una tabla llamada EMPLOYEE con al menos 10 columnas.
2. Usa esta tabla de ejemplo si no usas AdventureWorks:

CREATE TABLE EMPLOYEE (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    FirstName VARCHAR(100),
    LastName VARCHAR(100),
    Email VARCHAR(100),
    Phone VARCHAR(50),
    Department VARCHAR(100),
    Position VARCHAR(100),
    HireDate VARCHAR(20),
    Salary FLOAT,
    Status VARCHAR(50)
);

3. Agrega tu conexión a base de datos en DBConnection.java.

Compilación

En la raíz del proyecto:

mvn clean package

Esto generará el archivo:

target/PruebaGBMJulioCayax-1.0-SNAPSHOT-jar-with-dependencies.jar

Ejecución desde consola

Modo inserción (leer JSON y guardar en DB)

java -Djava.library.path="C:\sqljdbc" -jar target/PruebaGBMJulioCayax-1.0-SNAPSHOT-jar-with-dependencies.jar insert

Modo lectura (leer DB y exportar CSV)

java -Djava.library.path="C:\sqljdbc" -jar target/PruebaGBMJulioCayax-1.0-SNAPSHOT-jar-with-dependencies.jar read

Esto genera un archivo empleados_YYYYMMDD.csv con los datos exportados.

Archivos importantes

- empleados.json: Contiene los datos para insertar.
- src/main/java/org/example: Contiene todo el código fuente.
- target/: contiene el .jar ejecutable.
- empleados_YYYYMMDD.csv: Archivo generado por el modo lectura.

Autor

Julio Cayax  
Ingeniero en Sistemas, Quetzaltenango, Guatemala  
Fecha de entrega: Abril 2025
