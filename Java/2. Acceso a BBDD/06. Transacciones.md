# 6. Transacciones

Datos de la bd a la que nos queremos conectar

```java
String cadenaConexion = "jdbc:mysql://localhost:3306/Ferreteria";
String user = "root";
String pass = "";
```

Establecer conexión con la bd lo guardaremos en la variable **con** para así poder acceder a ella en otras partes del programa.

```java
Connection con;
try {
  con = DriverManager.getConnection(cadenaConexion, user, pass);
  System.out.println("Se establecio la conexion");
} catch (SQLException e) {
  System.out.println("No se ha podido establecer la conexion");
  System.out.println(e.getMessage());
  return;
}
```

> Cada vez que hacemos una acción como UPDATE, INSERT, SELECT, DELETE internamente se esta realizando un commit que avisa a la bd de esta acción
> 

Lo que hace el principio de **transaccionalidad** es hacer 1 solo commit cuando ya se han realizado todas las acciones con la base de datos.

Es decir 1 commit que contenga todas las acciones realizadas.

Para eso tenemos que desactivar los commits

```java
con.setAutoCommit(false);
```

Realizamos todas las interacciones con la bd

```java
try {
  //cada vez que hacemos una interaccion cn la bd se hace un commit avisando
  //la idea seria quitar ese autocmmit y hacer uno cuando se ejecuten todas las query
  con.setAutoCommit(false);
	
  //no tenemos q usar Statement hay q usar PrepareStatement
  Statement sentencia = con.createStatement();
	
  //Simulamos el alta de un cliente con una factura que tiene asociada unos productos
  //Hay que modificar todas las tablas y si no se puede, no hay que modificar ninguna
  String sql = "INSERT INTO CLIENTE VALUES ('51666666A','ROCAFLOR DELGADO RODOLFO', 'C/ PITONISA, 45', '616656644', 'SEVILLA');";
  sentencia.executeUpdate(sql);
  sql = "INSERT INTO FACTURA VALUES (5446,'2018/04/23', 0, '51666666A');";
  sentencia.executeUpdate(sql);
  sql = "INSERT INTO DETALLE VALUES (5446,'MAR2', 1, 7);";//factura - producto - cantidad - precio
  sentencia.executeUpdate(sql);		
  sql = "INSERT INTO DETALLE VALUES (5446,'TOR7', 2, 0.8);";
  sentencia.executeUpdate(sql);	
  sql = "UPDATE PRODUCTO SET STOCK=STOCK-1 WHERE CODIGO='MAR2'";
  sentencia.executeUpdate(sql);	
  sql = "UPDATE PRODUCTO SET STOCK=STOCK-2 WHERE CODIGO='TOR7'";
  sentencia.executeUpdate(sql);
	
  //hacemos un commit de todas las acciones de las query
  con.commit();
	
} catch (SQLException e) {
  System.out.println("No se pudo ejecutar la transaccion");
  System.out.println(e.getMessage());
	
  //en caso de q tengamos algun errror eliminamos 
  //las anteriores query q se hayan lanzado
  con.rollback();
}
```

Y hacemos el commit de las acciones realizadas.

```java
con.commit();
```

En caso de que no se pudiera realizar alguna de estas acciones eliminamos las querys que se hayan realido

```java
con.rollback();
```