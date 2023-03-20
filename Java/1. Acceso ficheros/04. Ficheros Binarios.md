# 4. Ficheros Binarios

## Escritura de fichero binario SIN Autoclose

```java
public static void main(String[] args){
  Producto p1 = new Producto("pero", 2.50f, 7);
  Producto p2 = new Producto("pera", 3.25f, 12);
  Producto p3 = new Producto("platano", 2.20f, 25);

  List<Producto> listaProducto = new ArrayList<Producto>();
  listaProducto.add(p1);
  listaProducto.add(p2);
  listaProducto.add(p3);

  //para trabaja cn fichero binarios podemo usar la 2 siguiente clase
  FileOutputStream fichero;
  DataOutputStream escritor;

  //apertura del fichero almacen.dat
  try{
    fichero = new FileOutputStream("almacen.dat", true);//fichero modo añadir (mantiene lo que habia)
    escritor = new DataOutputStream (fichero);
  }catch (IOException e){
    System.out.println("No se puede abrir el fichero almacen.dat");
    System.out.println(e.getMessage());
    return;
  }

  //Escribimos en el fichero almacen.dat
  try{
    for(Producto p : listaProductos){
      escritor.writeUTF(p.getNombre);//escribimos en UTF-8
      escritor.writeFloat(p.getPrecio());//escribinos en float
      escritor.writeInt(p.getStock);
    }
  }catch (IOExecption e){
    System.out.println("Error al escribir en el fichero");
    System.out.println(e.getMessage());
  }

  //cerramos los canales de comunicacion
  try{
    escritor.close();
    fichero.close();
  }catch (IOException e){
    System.out.println("Ha ocurrido un error al cerrar el fichero");
    System.out.println(e.getMessage());
  }

}
```

Cuando ejecutemos el programa nos creara un fichero llamado almacen.dat pero no podremos leerlo (ya que esta en binario) necesitaríamos algo que pudiera leer archivos binarios

---

## Escritura de fichero binario CON Autoclose

```java
public static void main(String[] args){
  Producto p1 = new Producto("pero", 2.50f, 7);
  Producto p2 = new Producto("pera", 3.25f, 12);
  Producto p3 = new Producto("platano", 2.20f, 25);

  List<Producto> listaProducto = new ArrayList<Producto>();
  listaProducto.add(p1);
  listaProducto.add(p2);
  listaProducto.add(p3);
	
  try(FileOutputStream fichero = new FileOutputStream("almacen.dat", true);
        DataOutputStream escritor = new DataOutputStream (fichero);) {

    for(Producto p : listaProductos){
      escritor.writeUTF(p.getNombre);//escribimos en UTF-8
      escritor.writeFloat(p.getPrecio());//escribinos en float
      escritor.writeInt(p.getStock);
    }
  }catch (IOException e){
    System.out.println(e.getMessage());
    return;//acabamos cn el programa
  }

}
```

---

## Lectura de ficheros binarios CON Autoclose

```java
public static void main(String{] args) {
	
  //Para leer de un fichero necesitamos los input
  try(FileInputStream fichero = new FileInputStream(almacen.dat);
      DataInputStream lector = new DataInputStream (fichero);){
      
    boolean eof = false;
    while (!eof){
    //cada vez que leemos algo, es subceptible a que de un EOFException
      try{
        String pro = lector.readUTF();
        float pre = lector.reafFloat();
        int uni = lector.readInt();
        Producto p = new Producto(pro, pre, uni);
        System.out.println(p);
      }catch(EOFException e1) {
        //excepcion en caso de estar en eof (end of file)
        eof = true;
      }catch(IOException e2) {
        System.out.println("Ha ocurrido un error al leer los registros");
        System.out.println(e2.getMessage());
        break;//sale del bucle while
      }
    }
  }catch (IOException e){
    System.out.println("Ha ocurrido un error al abrir el fichero");
    System.out.println(e.getMessage());
    break;
  }

}
```