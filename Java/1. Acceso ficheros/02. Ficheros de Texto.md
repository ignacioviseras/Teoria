# 2. Ficheros de Texto

### ¿Qué es un Stream?

Stream → es un canal por el cual fluye la información desde la aplicación a otro lado y viceversa.

1. Output → Desde la app para fuera
2. Input → Desde fuera hacia la app

### FileWriter

### PrintWriter

---

Es una clase que nos permitirá escribir en ficheros.

⚠️Solo ficheros⚠️

Es una clase mas genérica que nos permite escribir.

⚠️En un momento determinado podemos usarlo para un socket⚠️

Cuando manejamos **ficheros** normalmente nos arrojaran **excepcione tipo checked** para manejar estas excepciones usaremos un bloque try/catch 

Cada vez que hacemos esto estamos creando un archivo nuevo en modo de escritura y borrara el anterior.

```java
public static final String NOMBRE_FICHERO = "prueba.txt";//nombre del archivo + extension

public static void main(String[] args){
  FileWriter fw = null;
  PrintWriter pw = null;
	
  try{
    fw = new FileWriter(NOMBRE_FICHERO);//asi estariamos sobreescribiendo el contenido
    fw = new FileWriter(NOMBRE_FICHERO, true);//asi estariamos añadiendo contenido
		
    pw = new PrintWriter(fw);
    //⚠️FileWriter = canal de salida⚠️
    //⚠️PrintWriter = objeto que utilice el canal de salida(FileWriter)⚠️
    pw.println("Esto es una prueba de escritura en el fichero");
  }catch(IOException e){
    e.printStackTrace();
  }finally{//en caso de q se produzca el try se accedera aqui luego
  //⚠️siempre debemos cerrar el fichero despues de usarlo⚠️
    if(fw != null && pw != null){
      pw.close();
      try{
        fw.close();
      }catch (IOException e){
        e.printStackTrace();
      }
    }
  }

}
```

### 👀No se produce la escritura del fichero **hasta que se cierre** este👀

---

# Escritura de Fichero con Buffer

```java
public static void main(String[] args){
	
  //Abrir fichero para escritura
  FileWriter file;
  try{
    file = new FileWriter("peliculas.txt");
  }catch (IOException e){
    System.out.println("No se puede abrir o crear el fichero");
    System.out.println(e.getMessage());
    return;
  }
//-----------------------------------------------------
	//Abrir buffer y escribir tres lineas
  BufferedWriter buffer = new BufferedWriter(file);
  try{
    buffer.write("Madre anoche en las trincheras");
    buffer.newline();
    //buffer.flush();//nos permite escribir la informacion del buffer sin tener que esperar a q se cierre el archivo
    buffer.write("Entre el fuego y la metralla");
    buffer.newline();
    buffer.write("Vi al enemigo correr");
    buffer.newline();
  }catch (IOException e){
    System.out.println("Error al escribir en el fichero");
  }

}
```

---

# Lectura de Fichero con Buffer

⚠️xxxx hace referencia al nombre del archivo .java en el que estaría el código de arriba⚠️

```java
public static void main(String[] args){
  System.out.println("Vamos a leer el fichero de texto" + xxxx.NOMBRE_FICHERO);
	
  FileReader fr = null;
  BufferedReader br = null;
	
  try {
    fr = new FileReader(xxxx.NOMBRE_FICHERO);
    br = new BufferedReader(fr);
    //EOF = end of file
    String frase = br.readLine();//si estamos en EOF entonces se apuntan a null
    while(frase != null){
      System.out.println("Frase del fichero " + frase);
      frase = br.readLine();
    }
    System.out.println("Fichero leido correctamente");
  }catch (FileNotFoundException e){
    e.printStackTrace();
  }catch (IOException e){
    e.printStackTrace();
  }finally{
    try{
      if(br != null)
        br.close();
      if(fr != null)
        fr.close();
    }catch (IOException e){
      e.printStackTrace();
    }
  }
  
}
```