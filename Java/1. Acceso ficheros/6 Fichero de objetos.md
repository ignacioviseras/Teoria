# 6. Fichero de objetos

La interfaz Serializable sirve para decirle a la JVM que permite salir de la JVM a un fichero

### Escribir **un** objeto en fichero

```java
public static void main(String args[]){
  Alumno alu = new Alumno("Pedro", 20);
	
  alu.calificar("Mate", 50);
  alu.calificar("Fisica", 50);
  alu.calificar("Historia", 50);

  try(FileOutputStream file = new FileOutputStream("alumno.dat");
      ObjectOutputStream escritor = new ObjectOutputStream(file);){

    escritor.writeObject(alu);
  }catch(IOException e){
    e.printStackTrace();
    System.out.println(e.getMessage());
    return;
  }

}
```

---

### Leer **un** objeto en fichero

```java

public static void main(String args[]) throws ClassNotFoundException{
  try (FileInputStream file = FileInputStream("alumno.dat");
        ObjectInputStream escritor = new ObjectInputStream(file);){

    Alumno alu = (Alumno) escritor.readObject();//importante castearlo pq devuelve un objeto
    System.out.println("Nombre: "+ alu.getName);
    System.out.println("Edad: "+ alu.getAge);
    for(Calificacion c : alu.getCalificaciones()){
      System.out.println(c);
    }
  }catch (IOException e){
    e.printStackTrace();
  }

}
```

---

### Escritura de varios Objetos

```java
public static void main(String[] args){
  Contacto c1 = new Contacto("Amelia", "123456");
  Contacto c2 = new Contacto("Maria", "2344423");
  Contacto c3 = new Contacto("Fran", "1233324");

  try(FileOutputStream file = new FileOutputStream("agenda.dat", true);
        ObjectOutputStream buffer = new ObjectOutputStream(file)){

    buffer.writeObject(c1);
    buffer.writeObject(c2);
    buffer.writeObject(c3);
    System.out.println("Contactos guardados");
  }catch (IOException e){
    System.out.println("No se pudo abrir el fichero");
    System.out.println(e.getMessage());
    return;
  }

}
```

---

### Lectura de varios Objetos

```java
public static void main(String[] args){
  try(FileInputStream file = new FileInputStream("agenda.dat");
        ObjectInputStream buffer = new ObjectInputStream(file);){

    //leemos la lista de contactos
    boolean eof = false;
    Contacto c;
    while (!eof){//leemos hasta que sea el fin del fichero
      try {
        c = (Contacto) buffer.readObject();//lee los contactor del fichero
        System.out.println(c);

      }catch(EOFException e1){//si salta la excepcion termino el fichero
        eof = true
      }catch(IOException e2){
        System.out.println("Error al leer los contactos de la agenda");
        System.out.println(e2.getMessage());
      }catch(ClassNotFoundException e3){
        System.out.println("La clase de contacto no esta cargada en memoria");
        System.out.println(e3.getMessage());
      }
    }

  }catch (IOException e) {
    System.out.println("No se ha podido abrir la agenda de contactos");
    System.out.println(e.getMessage());
    return;
  }

}
```