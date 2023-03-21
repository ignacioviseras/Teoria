# 5. Dando estilo a la GUI I-II

Vamos a darle un poco de estilo a nuestra GUI no solo colores también le añadiremos algunas acciones.

<p align="center">
  <img src="fotosReadme/Untitled.png">
</p>

Actualmente cuando añadimos un texto en la caja y le damos al botón de saludar se nos cambia el titulo y si le damos al botón de borrar se vaciara la caja de texto **PERO** no estará el cursor marcado en la caja.

Esto se puede solucionar en el **ManejadorEventos**→ **actionPerformed y añadimos un requestFocus()**

```java
public class ManejadorEventos implements ActionListener{
  @Override
  public void actionPerformed(ActionEvent e) {
    ////BotonSaludar
    if(e.getSource() == ventana.getBoton())
      ventana.setTitle("Hola " + ventana.getCajaTexto().getText());

    //⚠️BotonReset⚠️
    if (e.getSource() == ventana.getBotonReset()){
      ventana.getCajaTexto().setText("");
      ventana.getCajaTexto().requestFocus();//⚠️nos activara la caja de texto
    }
  }
}
```

## ¿Cómo se puede cambiar la estética?

Vamos a ver como cambiar el **color de fondo**, **colores botones**, **fuente**….

Para esto tenemos que conocer 2 clases de la API de java.

## 1. Color

La clase Color nos permite darle color a las cosas estos colores se pueden indicar usando:

1. Nombre
2. RGB
3. RGBA (A → transparencia)

## 2. Font

La clase Font nos permite cambiar el tipo de letra esto se puede hacer de la siguiente manera:

1. Nombre
    - Fuente que queremos usar
2. Estilo
    - Negrita
    - Cursiva
3. Tamaño
    - El tamaño que queremos que tenga

---

Vamos a empezar cambiando el color de fondo de la ventana.

- Esto se puede hacer usando un panel (un contenedor) → JPanel que ocupe toda la ventana y asignarle un color
- También se puede hacer indicándolo directamente.
    
    ```java
    private void inicializarComponentes() {
      //esto se aplicara sobre la ventana principal
      getContentPane().setBackground(new Color(102, 0, 153));
    }
    ```
    

Además cambiaremos el texto del JLabel por una imagen

```java
etiqueta = new JLabel(new ImageIcon("src/fotos/persona.png"));
```

<p align="center">
  <img src="fotosReadme/Untitled%201.png">
</p>

Ahora modificaremos la caja de texto 

```java
private void inicializarComponentes() {
  cajaTexto = new JTextField();
  cajaTexto.setBounds(110, 30, 110, 30);
  cajaTexto.setBorder(null);//quitamos el borde de la caja de texto
  cajaTexto.setFont(new Font("Dialog", Font.BOLD, 14));//idicamos la fuente del texto
  cajaTexto.setForeground(new Color(102, 0, 153));//color de las letras
  add(cajaTexto);
}
```

También cambiamos el aspecto de los botones

```java
private void inicializarComponentes() {
  boton = new JButton("Saludar");
  boton.setBounds(50, 80, 170, 30);
  boton.setFont(new Font("Dialog", Font.BOLD, 14));//idicamos la fuente del texto
  boton.setForeground(new Color(102, 0, 153));//color de las letras
  boton.setBackground(Color.WHITE);//color del boton
  add(boton);
}
```

Nos quedaría una cosa así.

<p align="center">
  <img src="fotosReadme/Untitled%202.png">
</p>

---

## Ahora vamos a hacer que tenga un aspecto de app de teléfono

Para eso cambiamos el tamaño de la ventana en VentanaPrincipal.java → VentanaPrincipal()

```java
setSize(285, 445);
```

Y tendremos que bajar la ubicación de los componentes.

```java
etiqueta.setBounds(50, 30, 50, 30);//Antes
etiqueta.setBounds(45, 200, 50, 30);//Ahora

cajaTexto.setBounds(110, 30, 110, 30);//Antes
cajaTexto.setBounds(100, 200, 120, 30);//Ahora

boton.setBounds(50, 80, 170, 30);//Antes
boton.setBounds(50, 250, 170, 30);//Ahora

botonReset.setBounds(50, 120, 170, 30);//Antes
botonReset.setBounds(50, 300, 170, 30);//Ahora
```

Nos quedara una cosa así

<p align="center">
  <img src="fotosReadme/Untitled%203.png">
</p>

Ahora cambiaremos el icono la persona que tenemos por uno blanco podemos usar [https://materialdesignicons.com](https://materialdesignicons.com/) para encontrar el icono que nosotros queremos.

Ahora añadiremos un icono en el espacio en vacío que tenemos.

```java
private JLabel logo;

private VentanaPrincipal(){
  logo = new JLabel(new ImageIcon("src/fotos/perfil.png"));
  logo.setBounds(45, 45, 50, 50);
  add(logo);
}
```

Si ejecutamos esto la imagen saldrá cortada.

<p align="center">
  <img src="fotosReadme/Untitled%204.png">
</p>

Para que la imagen nos salga completa tendremos que crearnos un objeto Image para luego escalarlo 

Tendremos que indicar los siguientes parámetros:

- **width** → el ancho al que escalar la imagen.
- **height** → la altura a la que escalar la imagen.
- **hints** → banderas para indicar el tipo de algoritmo a usar para el remuestreo de imágenes.

```java
private void inicializarComponentes() {
  Image img = new ImageIcon("src/fotos/perfil.png").getImage();//escalado de foto
  logo = new JLabel(new ImageIcon(img.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));//escalado de foto
  logo.setBounds(95, 20, 80, 80);
  add(logo);
}
```

<p align="center">
  <img src="fotosReadme/Untitled%205.png">
</p>

Ahora vamos a **cambiar la fuente** de texto utilizando una de internet para eso iremos a [https://www.dafont.com/es/](https://www.dafont.com/es/) y nos descargaremos la que mas nos guste y la colocamos dentro de un paquete nuevo llamado fuentes.

Tendremos que indicar un formato y el fichero en el que se encuentra la fuente.

```java
private JLabelnombreApp;

private void inicializarComponentes() {
  try {
    Font fuente = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("../fuentes/space age.ttf"));//ubicacion de la fuente

    nombreApp = new JLabel("Mi App");//texto que tendra la label
    nombreApp.setHorizontalAlignment(SwingConstants.CENTER);//centramos el contenido
    nombreApp.setFont(fuente.deriveFont(Font.BOLD, 40f));//indicamos q fuente se usara ademas decimos q sea negrita y de tamaño 40 (la f es pq es float)
    nombreApp.setBounds(0, 120, 285, 30);//tamaño/posicionamiento
    nombreApp.setForeground(Color.WHITE);
    add(nombreApp);
  } catch (FontFormatException e) {
    e.printStackTrace();
  } catch (IOException e) {
    e.printStackTrace();
  }
}
```

Al guardar nos quedara una cosa asi.

<p align="center">
  <img src="fotosReadme/Untitled%206.png">
</p>
