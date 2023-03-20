# 2. BBDD Conexión

# ¿Cómo conectamos la bd con java?

Para conectarnos a una base de datos tenemos que seguir los siguientes pasos

## 1. Crear los datos que establecerán la conexión

```java
String cadenaConexion = "jdbc:mysql://localhost:3306/bd_prueba";
String user = "root";
String pass = "";
```

## 2. Establecer la conexión

**DriverManager** → Es una clase que gestiona las conexiones

cuando usamos **getConnection** estamos pidiendo una conexion

```java
Connection con = null;
try {
  con = DriverManager.getConnection(cadenaConexion, user, pass);
  System.out.println("se establecio la conex");
}catch (SQLException  e) {
  System.out.println("No se pudo establecer la conexion");
  System.out.println(e.getMessage());
  return;
}
```

## 3. Hacer las interacciones con la base de datos

Lo veremos más adelante.

## 4. Cerrar la conexión

```java
try {
  con.close();
} catch (SQLException e) {
  System.out.println("No se pudo cerrar la conexion");
  System.out.println(e.getMessage());
  return;
}
```