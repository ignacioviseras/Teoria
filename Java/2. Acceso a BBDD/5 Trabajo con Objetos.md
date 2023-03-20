# 5. Trabajo con Objetos

En todos los casos tendremos que tener unos parámetros de conexión a la bd

```java
String cadenaConexion = "jdbc:mysql://localhost:3306/bd_prueba";
String user = "root";
String pass = "";
```

- Sentencia sql
    
    **SELECT * FROM personas** para mostrar todos los datos de una persona
    

**rs.next** → Comprueba que se tengan mas filas para mostrar

**rs.getXXX** → Recuperamos el dato que indicamos entre los “”

Almacenamos el dato en el objeto persona y lo metemos a una lista para luego pintarla

```java
try(Connection con = DriverManager.getConnection(cadenaConexion, user, pass)){
  PreparedStatement sentencia = con.prepareStatement("SELECT * FROM PERSONAS");
  ResultSet rs = sentencia.executeQuery();
	
  List<Persona> listadoPersonas = new ArrayList<Persona>();
  while (rs.next()) {
    Persona p = new Persona();
    p.setId(rs.getInt("ID"));
    p.setNombre(rs.getString("NOMBRE"));
    p.setEdad(rs.getInt("EDAD"));
    p.setPeso(rs.getInt("PESO"));
		
    listadoPersonas.add(p);
  }
  System.out.println(listadoPersonas);
	
}catch (SQLException e) {
  System.out.println("Error al realizar el listado de productos");
  System.out.println(e.getMessage());
}
```