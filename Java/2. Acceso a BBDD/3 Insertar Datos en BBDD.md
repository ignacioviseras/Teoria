# 3. Insertar Datos en BBDD

Para hacer conexiones con bases de datos usaremos esta manera.

Tendremos que pasar los parámetros de conexión a la bd

```java
String cadenaConexion = "jdbc:mysql://localhost:3306/bd_prueba";
String user = "root";
String pass = "";
```

En el bloque try-catch hacemos la conexión que será autoclose

- Creamos un string con la sentencia sql menos los datos a insertar en vez de ellos tendremos ?
- Usando PreparedStatement modificaremos la sentencia sql
- Una vez modificada usamos **sentencia.executeUpdate()** para ejecutar el sql

```java
try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass)){
  String sql = "INSERT INTO PERSONAS (NOMBRE, EDAD, PESO) " + "VALUES (?, ? , ?)"; //ponemos ? en vez de los valores
  String nombre = "asd";
  int edad = 80;
  double peso = 50;
	
  System.out.println("Se va a ejecutar la accion sql->  " + sql);
	
  PreparedStatement sentencia;
  sentencia = con.prepareStatement(sql);//aqui estamos creando un objeto de la sentencia sql
  //esto son consultas parametrizadas
  sentencia.setString(1, nombre);//el 1 hace referencia al primer ? que aparece en la sentencia q sera sustituido por el dato de la variable
  sentencia.setInt(2, edad);
  sentencia.setDouble(3, peso);
	
  //ejecutamos la query
  int afectados = sentencia.executeUpdate();
  System.out.println("Sentencia sql ejecutada con exito");
  System.out.println("Registros afectados: " + afectados);
}catch (SQLException e) {
  System.out.println("Error al añadir una nueva persona");
  System.out.println(e.getMessage());
}
```