# 1. Clase File

Con la clase **File** se puede trabajar tanto con ficheros como con directorios.

### ¿Cómo se usa?

- Creamos una instancia de File
    
    ```java
    //***** Ficheros *****
    File fl = new File("file.txt");//forma **relativa** (se locacliza en la raiz del proyecto java)
    File fl = new File("C:\\file.txt");//forma **************absoluta************** (La ubicacion global del archivo)
    
    //***** Directorios *****
    File dr = new File("directory.txt");//forma **relativa** (se locacliza en la raiz del proyecto java)
    File dr = new File("C:\\directory.txt");//forma **************absoluta************** (La ubicacion global del archivo)
    ```
    

- ¿Cómo crear un fichero?
    1. Necesitamos comprobar que el fichero no existe.
    2. Lo creamos.
    
    ```java
    if (!fl.exists()){//1
      fl.createNewFile();//2
    }
    ```
    

- ¿Cómo creamos un directorio?
    1. Necesitamos comprobar que el directorio no existe.
    2. Lo creamos.
    
    ```java
    if (!dr.exists()){//1
      dr.mkdir();//2
    }
    ```
    
- Para obtener el nombre del fichero/directorio podemos usar.
    
    ```java
    fl.getName();
    dr.getName();
    ```
    

⚠️Siempre que se crea un fichero/directorio en eclipse hay q refrescar el proyecto ya que no se actualiza automáticamente.⚠️

---

### Comprobaciones

- Si utilizamos:
    
    ```java
    fl.isDirectory();
    fl.isFile();
    ```
    
    Nos devolverá un booleano en caso de que se cumpla la condición.
    

---

### Listado

```java
String content[] = fl.list();
```

Utilizando esto podemos listar el contenido de los directorios y subdirectorios esto se guardara en un array.

---

## Opciones útiles

- Permisos
    1. Nos permitirá saber si tenemos **permiso de lectura**.
    2. Nos permitirá saber si tenemos **permiso de escritura**.
        
        ```java
        fl.canRead();//1
        fl.canWrite();//2
        ```
        

- Modificaciones
    1. Nos mostrara la fecha de la ultima modificación. (es como el Date de java)
        
        ```java
        fl.lastModified();//1
        ```
        

- Tamaño
    1. Nos mostrara el tamaño del archivo **(nos lo dira en bytes)**
        
        ```java
        fl.lenght();
        ```
        

- Borrar
    1. Utilizando esta función borraremos el archivo.
        
        ```java
        fl.delete();
        ```
        

---