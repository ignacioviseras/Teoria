# 8. Patrón Dao - 2

Ahora vamos a realizar la implementación de la interfaz para eso nos vamos a nuestra clase dao

```java
public class DaoPersonaMySql implements IntPersonaDao{

}
```

# Conexiones con la BBDD

### 📡 abrirConexion

Este método nos permitirá **ABRIR** la conexión con la base de datos

```java
public Boolean abrirConexion() {
  String url = "jdbc:mysql://localhost:3306/bbdd";
  String user = "root";
  String pass = "";
	
  try {
    conex = DriverManager.getConnection(url, user, pass);
  } catch (SQLException e) {
    e.printStackTrace();
    return false;
  }
  return true;
}
```

### 📡 cerrarConexion

Este método nos permitira **CERRAR** la conexion con la base de datos

```java
public Boolean cerrarConexion() {
  try {
    conex.close();
  } catch (SQLException e) {
    e.printStackTrace();
    return false;
  }
  return true;
}
```

# Acciones

### 📡 alta

Con este método podremos **CREAR** nuevos registros en la base de datos

1. Hacemos una comprobación de que se puede realizar la conexión con la base de datos
    - En caso de que no se pueda realizar nos devolverá un null (esto se hace para que no se rompa el programa)
2. Creamos la sentencia SQL que queremos realizar
    - Las ? son los sitios en los que ingresaremos los datos.
3. Accedemos a la sentencia SQL para poder sustituir los datos
    - `ps.setString(1, p.getNombre());` el hace referencia a que ? será en la que se ingrese el dato.
4. Ejecutamos la query
    - Si devuelve **1** significa que **SI** se realizo la operación
    - Si devuelve **0** significa que **NO** se realizo la operación
        - En caso de que no se realice la operación devolvemos un false
5. Cerramos la conexión
6. Avisamos de que se pudo realizar la operación sin ningún tipo de problemas

```java
@Override
public boolean alta(Persona p) {
  if(!abrirConexion()) {//1
    return false;
  }
  boolean alta = true;
	
  String query = "insert into personas (NOMBRE, EDAD, PESO) values(?,?,?)";//2
	
  try {
    //insertamos los datos en los ? de la query
    PreparedStatement ps = conex.prepareStatement(query);//3
    ps.setString(1, p.getNombre());//3
    ps.setInt(2, p.getEdad());//3
    ps.setDouble(3, p.getPeso());//3
		
    int numeroFilasAfectadas = ps.executeUpdate();//4
    if(numeroFilasAfectadas == 0)//4
      alta = false;//4
		
  } catch (SQLException e) {
    System.out.println("alta-> Error al insertar: " + p);
    alta = false;
    e.printStackTrace();
  } finally {
    cerrarConexion();//5
  }
  return alta;//6
}
```

### 📡 baja

Con este método podremos **BORRAR** registros en la base de datos

1. Hacemos una comprobación de que se puede realizar la conexión con la base de datos
    - En caso de que no se pueda realizar nos devolverá un null (esto se hace para que no se rompa el programa)
2. Creamos la sentencia SQL que queremos realizar
    - Las ? son los sitios en los que ingresaremos los datos.
3. Accedemos a la sentencia SQL para poder sustituir los datos
    - `ps.setInt(1, id);` el hace referencia a que ? será en la que se ingrese el dato.
4. Ejecutamos la query
    - Si devuelve **1** significa que **SI** se realizo la operación
    - Si devuelve **0** significa que **NO** se realizo la operación
        - En caso de que no se realice la operación devolvemos un false
5. Cerramos la conexión
6. Avisamos de que se pudo realizar la operación sin ningún tipo de problemas

```java
@Override
public boolean baja(int id) {
  if(!abrirConexion()) {//1
    return false;//1
  }
  boolean borrado = true;
  String query = "delete from personas where id = ?";//2
  try{
    PreparedStatement ps = conex.prepareStatement(query);//3
    //sustituimos la ? por el id
    ps.setInt(1, id);//3
    int numeroFilasAfectadas = ps.executeUpdate();//4
    if(numeroFilasAfectadas == 0)//4
      borrado = false;//4
		
  }catch (SQLException e) {
    borrado = false;
    System.out.println("baja -> No se realizo la baja del id: " + id);
    e.printStackTrace();
	
  }finally {
    cerrarConexion();//5
  }
	
  return borrado;//6
}
```

### 📡 modificar

Con este método podremos **MODIFICAR** registros de la base de datos

1. Hacemos una comprobación de que se puede realizar la conexión con la base de datos
    - En caso de que no se pueda realizar nos devolverá un null (esto se hace para que no se rompa el programa)
2. Creamos la sentencia SQL que queremos realizar
    - Las ? son los sitios en los que ingresaremos los datos.
3. Accedemos a la sentencia SQL para poder sustituir los datos
    - `ps.setString(1, p.getNombre());`  el hace referencia a que ? será en la que se ingrese el dato.
4. Ejecutamos la query
    - Si devuelve **1** significa que **SI** se realizo la operación
    - Si devuelve **0** significa que **NO** se realizo la operación
        - En caso de que no se realice la operación devolvemos un false
5. Cerramos la conexión
6. Avisamos de que se pudo realizar la operación sin ningún tipo de problemas

```java
@Override
public boolean modificar(Persona p) {
  if(!abrirConexion())//1
    return false;//1
	
  boolean modificado = true;
  String query = "update personas set NOMBRE=?, EDAD=?, PESO=?, WHERE ID=?";//2
	
  try {
    PreparedStatement ps = conex.prepareStatement(query);//3
    ps.setString(1, p.getNombre());//3
    ps.setInt(2, p.getEdad());//3
    ps.setDouble(2, p.getPeso());//3
    ps.setInt(4, p.getId());//3
		
    int numeroFilasAfectadas = ps.executeUpdate();//4
    if(numeroFilasAfectadas == 0)//4
      modificado = false;//4
		
  } catch (SQLException e) {
    System.out.println("modificar -> error al modif " + p);
    modificado = false;
    e.printStackTrace();
  }finally {
    cerrarConexion();//5
  }
  return modificado;//6
	
}
```

### 📡 obtener

Con este método podremos **OBTERNER** registros de la base de datos

1. Hacemos una comprobación de que se puede realizar la conexión con la base de datos
    - En caso de que no se pueda realizar nos devolverá un null (esto se hace para que no se rompa el programa)
2. Creamos la sentencia SQL que queremos realizar
    - Las ? son los sitios en los que ingresaremos los datos.
3. Accedemos a la sentencia SQL para poder sustituir los datos
    - `ps.setInt(1, id);`  el hace referencia a que ? será en la que se ingrese el dato.
4. Ejecutamos la query
    - Si devuelve **1** significa que **SI** se realizo la operación
    - Si devuelve **0** significa que **NO** se realizo la operación
        - En caso de que no se realice la operación devolvemos un false
5. Vamos guardando los registros que recibimos de la bbdd en un objeto persona.
    - En este caso el 1 hace referencia a primer elemento de la consulta SQL
    `persona.setId(rs.getInt(1));`
6. Cerramos la conexión
7. Devolvemos la persona

```java
@Override
public Persona obtener(int id) {
  if(!abrirConexion())//1
    return null;//1
	
  Persona persona = null;
  String query = "SELECT ID, NOMBRE, EDAD, PESO FROM PERSONAS WHERE ID=?";//2
	
  try {
    PreparedStatement ps = conex.prepareStatement(query);//3
    ps.setInt(1, id);//3
		
    ResultSet rs = ps.executeQuery();//4
    while(rs.next()) {//5
      persona = new Persona();//5
      persona.setId(rs.getInt(1));//5
      persona.setNombre(rs.getString(2));//5
      persona.setEdad(rs.getInt(3));//5
      persona.setPeso(rs.getDouble(4));//5
    }
  } catch (SQLException e) {
    System.out.println("obtener-> error al obtener la persona cn id " + id);
    e.printStackTrace();
  }finally {
    cerrarConexion();//6
  }
  return persona;//7
}
```

### 📡 listar

Con este método podremos **LISTAR** registros de la base de datos

1. Hacemos una comprobación de que se puede realizar la conexión con la base de datos
    - En caso de que no se pueda realizar nos devolverá un null (esto se hace para que no se rompa el programa)
2. Creamos la sentencia SQL que queremos realizar
    - Las ? son los sitios en los que ingresaremos los datos.
3. Ejecutamos la query
    - Si devuelve **1** significa que **SI** se realizo la operación
    - Si devuelve **0** significa que **NO** se realizo la operación
        - En caso de que no se realice la operación devolvemos un false
4. Vamos guardando los registros que recibimos de la bbdd en un objeto persona.
    - En este caso el 1 hace referencia a primer elemento de la consulta SQL
    `persona.setId(rs.getInt(1));`
5. Añadimos el objeto persona a un ArrayList
6. Cerramos la conexión
7. Devolvemos la lista de personas

```java
@Override
public List<Persona> listar() {
  if(!abrirConexion())//1
    return null;//1
  List<Persona> listaPersonas = new ArrayList<>();
  String query = "SELECT ID, NOMBRE, EDAD, PESO FROM PERSONAS";//2
		
  try {
    PreparedStatement ps = conex.prepareStatement(query);
    ResultSet rs = ps.executeQuery();//3
			
    while (rs.next()) {//SE EJECUTARA SIEMPRE QUE TENGAMOS UN REGISTRO PARA MOSTRAR
      Persona persona = new Persona();//4
      persona.setId(rs.getInt(1));//4
      persona.setNombre(rs.getString(2));//4
      persona.setEdad(rs.getInt(3));//4
      persona.setPeso(rs.getDouble(4));//4
				
      listaPersonas.add(persona);//5
    }
			
  } catch (SQLException e) {
      System.out.println("listar-> error al recuperar la lista");
      e.printStackTrace();
  }finally {
      cerrarConexion();//6
  }
			
  return listaPersonas;//7
}
```

---

### Como lo ejecutamos

En el main tendriamos que crearnos una variable DaoPersona y hacemos llamamiento a las funciones.

```java
DaoPersona pdao = new DaoPersona();
System.out.println(pdao.listar());
```