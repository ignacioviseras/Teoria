# 3. Ficheros de texto Autoclose

Ahora vamos a ver una manera para automatizar el cerrado de ficheros esto se hace gracia a java de tal manera que si iniciamos en el try las variables se cerraran automáticamente al salir de este.

## Escritura de fichero con AutoClose

```java
public static void main(String[] args){
  System.out.println("Estructura de fichero" + NOMBRE_FICHERO);

  try(FileWriter fr = new FileWriter(NOMBRE_FICHERO);
       BufferedWriter pw = new BufferedWriter(fr);){
		
    pw.write("Esto es una prueba de escritura en el fichero");
    pw.nextLine();
    pw.write("Aqui podemos escribir lo que queramos");
    pw.flush();
    //⚠️cuando salga de aqui se cerrar automaticamente⚠️
  } catch (IOException e){
    e.printStackTrace();
  }

}
```

---

## Lectura de fichero con AutoClose

```java
public static void main(String[] args){
  System.out.println("Vamos a leer el fichero de texto" + xxxx.NOMBRE_FICHERO);
	
  try (FileReader fr = new FileReader(xxxx.NOMBRE_FICHERO);
        BufferedReader br = new BufferedReader(fr);){
		
    //EOF = end of file
    String frase = br.readLine();//si estamos en EOF entonces se apuntan a null
    while(frase != null){
      System.out.println("Frase del fichero " + frase);
      frase = br.readLine();
    }
    pw.println("Esto es una prueba de escritura en el fichero");
    }catch(IOException e){
      e.printStackTrace();
    }

}
```