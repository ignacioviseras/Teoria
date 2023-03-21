# Ventana Principal

Creacion de ventanas

1. Creacion de proyecto
File-> New-> Java Proyect-> Proyect name
2. Creacion paquetes
Dentro del proyecto tendremos que tener un paquete para la vista y otro para el controlador

<p align="center">
  <img src="fotosReadme/Untitled.png">
</p>

### En el paquete de vista

Crearmos la clase VentanaPrincipal.

Tendremos que añadir la libreria swing y hacemos que la clase extienda de JFrame
👀👀👀la ventana se maneja con en el JFrame 👀👀👀

dentro tendremos un constructor con el mismo nombre que la clase

añadimos los siguiente

Para indicar el **tamaño de la ventana** usamos esto ⬇️

El primer numero es para el width y el segundo para el height

```java
setSize(300, 300);
```

Para el posiciona miento de la ventana podemos hacerlo de 2 formas:

1. setLocationRelativeTo
   Si le pasamos un null lo que hace es crear la pantalla y colocarla en el centro.
    
    ```java
    setLocationRelativeTo(null);
    ```
    
2. setLocation  Indicamos las coordenadas en las que se localizara la esquina superior izquierda.
    
    ```java
    setLocation(int x, int y);
    ```
    

Para la X de cierre de ventana usamos

```java
setDefaultCloseOperation(opcion);
```

Opciones

1. EXIT_ON_CLOSE 
cierra la pestaña estera(indicada para paginas principales)
2. DO_NOTHING_ON_CLOSE
 si le damos no hace nada
3. HIDE_ON_CLOSE
 se oculta
4. DISPOSE_ON_CLOSE
 se pierde??

Tenemos que decir si queremos que la pestaña sea visible o no.

Para eso usaremos

```java
setVisible(true);
```

Opciones

1. True (queremos que se vea)
2. False (no queremos que se vea)

### Creamos un main

En este main llamamos a la clase VentanaPrincipal

```java
import vista.VentanaPrincipal;
VentanaPrincipal ventanaPrincip = new VentanaPrincipal();
```

Cuando guardemos todo ejecutamos el programa y se nos abrirá la ventana

<p align="center">
  <img src="fotosReadme/Untitled%201.png">
</p>

## Interaccion con el usuario

Para reajustar el tamaño usamos

```java
setResizable(boolean);
```

Opciones

1. True (en caso de **SI** **querer permitir redimensionar la ventana**)
2. False (si NO **queremos que se redimensione**)

Para ponerle un titulo la ventana usaremos

```java
setTitle(String);
/* Le pasamos un String usando las "" */
```

Para añadir fotos tenemos estas 2 formas

(tenemos q importar la libreria de toolkit)
💡Es recomendable tener las fotos en una carpeta

```java
//sin url tiene que estar al mismo nivel q src
setIconImage(Toolkit.getDefaultToolkit().getImage("fotoIcono.png"));
//con url
setIconImage(Toolkit.getDefaultToolkit().getImage("src/fotos/fotoIcono.png"));
```

El resultado final seria el siguiente

<p align="center">
  <img src="fotosReadme/Untitled%202.png">
</p>
