# 4. Listar, modificar y borrar en BBDD

En todos los casos tendremos que tener unos parámetros de conexión a la bd

```java
String cadenaConexion = "jdbc:mysql://localhost:3306/bd_prueba";
String user = "root";
String pass = "";
```

# Listar

- Sentencia sql
    
    **SELECT * FROM personas** para mostrar todos los datos de una persona
    

**rs.next** → Comprueba que se tengan mas filas para mostrar

**rs.getXXX** → Recuperamos el dato que indicamos entre los “”

```java
try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass)){
  PreparedStatement sentencia = con.prepareStatement("SELECT * FROM personas");
  ResultSet rs = sentencia.executeQuery();//no cambia registro
	
  while (rs.next()) {//preguntamos si hay mas filas para mostrar
    System.out.print(rs.getInt("ID"));//valor columna id
    System.out.print(" - ");
    System.out.print(rs.getString("NOMBRE"));//valor columna nombre
    System.out.print(" - ");
    System.out.print(rs.getInt("EDAD"));//valor columna edad
    System.out.print(" - ");
    System.out.print(rs.getDouble("PESO"));//valor columna peso
    System.out.println();//retorno de carro	
  }

} catch (SQLException e) {
  System.out.println("Error al listar");
  System.out.println(e.getMessage());
}
```

# Obtener

- Sentencia sql
    
    **SELECT * FROM PERSONAS WHERE ID=?** para mostrar todos los datos de una persona con el id que le indicaremos
    

A la query le indicamos que sustituiremos el ? por el dato que queremos de esta manera podemos buscar el usuario por id

**rs.next** → Comprueba que se tengan mas filas para mostrar

```java
try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass)){
  PreparedStatement sentencia = con.prepareStatement("SELECT * FROM PERSONAS WHERE ID=?");
  sentencia.setInt(1, 2);//el 1 hace referencia a la ? y el siguiente numero es por el cual sera sustituido
  ResultSet rs = sentencia.executeQuery();
  while(rs.next()) {
    System.out.print(rs.getInt("ID"));
    System.out.print(" - ");
    System.out.print(rs.getString("NOMBRE"));
    System.out.print(" - ");
    System.out.print(rs.getInt("EDAD"));
    System.out.print(" - ");
    System.out.print(rs.getDouble("PESO"));
    System.out.print(" - ");

  }
	
} catch (SQLException e) {
  System.out.println("Error al realizar el listado");
  System.out.println(e.getMessage());
}
```

# Modificar

- Sentencia sql
    
    **update personas set NOMBRE=?, EDAD=?, PESO=? WHERE ID=?** que usaremos para actualizar los datos de una persona
    

Introducimos los datos gracias al **Statement** donde indicaremos que el numero de ? sera sustituido por el dato de la variable.

**executeUpdate()** → Ejecutamos la funcion

```java
try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass)){
  String sql = "update personas set NOMBRE=?, EDAD=?, PESO=? WHERE ID=?";
	
  String nombre = "miguel gomez";
  int edad=60;
  double peso = 70;
  int id = 2;
	
  System.out.println("se va a ejecutar la sentencia sql");
  System.out.println(sql);
	
  //introducimos los datos en la sentencia sql
  PreparedStatement sentencia = con.prepareStatement(sql);
  sentencia.setString(1, nombre);
  sentencia.setInt(2, edad);
  sentencia.setDouble(3, peso);
  sentencia.setInt(4, id);
	
  //lanzamos la sentencia
  int afectados = sentencia.executeUpdate();
  System.out.println("se ejecuto con exito");
  System.out.println("registrs afectados " + afectados);
} catch (SQLException e) {
  System.out.println("");
  System.out.println(e.getMessage());
}
```

# Borrar

- Sentencia sql
    
    **DELETE FROM PERSONAS WHERE ID=?** → borramos la persona que tenga ese id
    

Introducimos los datos gracias al **Statement** donde indicaremos que el numero de ? será sustituido por el dato de la variable.

**executeUpdate()** → Ejecutamos la función

```java
try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass)){
  String sql = "DELETE FROM PERSONAS WHERE ID=?";
  int id = 2;
	
  System.out.println("Ejecutando sentencia sql " + sql);
	
  PreparedStatement sentencia = con.prepareStatement(sql);
  sentencia.setInt(1, id);
	
	
  int afectados = sentencia.executeUpdate();
  System.out.println("registros afectados " + afectados);
} catch (SQLException e) {
  System.out.println("Error al borrar");
  System.out.println(e.getMessage());
}
```