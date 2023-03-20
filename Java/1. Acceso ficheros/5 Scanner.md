# 5. Scanner

```java
public static void main(String args[]){
  String texto = "hola como estas";
  Scanner lector = new Scanner(texto);//en vez de sytem.in usamos el string
  while(lector.hashNext()){//va a comprobar si hay **mas despues del espacio** palabras
    System.out.println(lector.next());//accedemos a la palabra siguiente
  }

  lector.close();//cerramos el scanner
}
```

### Resultado

```
hola
como
estas
```

---

### Delimitando palabras

```java
public static void main(String args[]){
  String texto = "Juan pere;Paco Hernande;Hugo Lope;Mario ruiz";
  Scanner lector = new Scanner(texto);//en vez de sytem.in usamos el string
  lector.useDelimiter(";");//⚠️Delimitas los tramos de palabras cuando aparezca ;⚠️
  while(lector.hashNext()){//va a comprobar si hay **mas despues del espacio** palabras
    System.out.println(lector.next());//accedemos a la palabra siguiente
  }

  lector.close();//cerramos el scanner
}
```

```
Juan pere
Paco Hernande
Hugo Lope
Mario ruiz
```

---

### Para leer un fichero

```java
public static void main(String args[]){
  File fichero = new File("peliculas.txt");
  if(!fichero.exists()){//si no existe el fichero
    System.out.println("El fichero no existe");
    return;
  }

//*********Lectura del fichero************
  Scanner lector = new Scanner(fichero);//en vez de sytem.in usamos el string
  while(lector.hashNext()){//va a comprobar si hay **mas despues del espacio** palabras
    String linea = lector.nextLine();
    System.out.println(linea);//accedemos a la palabra siguiente
  }

  lector.close();//cerramos el scanner
}
```