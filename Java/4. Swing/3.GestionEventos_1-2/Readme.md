# 3. Gestión de eventos I-II

Ahora mismo tenemos esta ventana pero solo es una vista plana sin ninguna ejecución.

<p align="center">
  <img src="fotosReadme/Untitled.png">
</p>
<center>

Para hacer que funcionen los componentes tendremos que gestionar los eventos esto se hace utilizando unos **listeners**

Funcionamiento de un Listener

Los listeners son diferentes dependiendo de los eventos a los que van a dar respuesta, 3 objetos implicados:

1. **Objeto fuente** → Que es el objeto que lanza los eventos.
Ejemplo → Un botón
2. **Objeto de evento** → Es el suceso que se produce.
Ejemplo → Hacer click (sobre el botón)
3. **Listener** → Es el objeto que captura el evento y ejecuta el código correspondiente.
Ejemplo → la ventana (algo cambiara en la ventana o en algún componente que contiene esa ventana)

Ejemplo → Imagina que tenemos un botón, pues el botón estaría en todo momento a la escucha por si alguien hace click en el.
A esa acción se le llama evento y esa acción tiene que devolver una respuesta

<p align="center">
  <img src="fotosReadme/Untitled%201.png">
</p>

## <center> Eventos de Botón   /   Campo de Texto   /  Menú </center>

| Interface | Método | Métodos del evento “e” |
| --- | --- | --- |
| ActionListener | actionPerformed(ActionEvent e) 💭Se hizo click en el componente💭 | Object getSource() 💭Obtiene el objeto fuente que ha lanzado el evento💭 |

<br></br>
## <center> Eventos de Combo </center>

| Interface | Método | Métodos del evento “e” |
| --- | --- | --- |
| ItemListener | itemStateChanged(ItemEvent e) 💭Se ha seleccionado un elemento de la lista.💭 | Object getSource() 💭Obtiene el objeto fuente que ha lanzado el evento💭 |

<br></br>
## <center> Eventos de casillas de Verificación / Radios </center>

| Interface | Método | Métodos del evento “e” |
| --- | --- | --- |
| ChangeListener | stateChanged(ChangeEvent e) 💭Ha cambiado el estado (seleccionado/deseleccionado).💭 | Object getSource() 💭Obtiene el objeto fuente que ha lanzado el evento💭 |

<br></br>
## <center> Eventos del Teclado </center>

| Interface | Método | Métodos del evento “e” |
| --- | --- | --- |
| KeyListener | keyPressed(KeyEvent e) 💭Se ha pulsado una tecla..💭 | char getKeyChar() 💭Devuelve el carácter asociado con la tecla pulsada💭 |
| KeyListener | keyReleased(KeyEvent e) 💭Se ha liberado una tecla💭 | int getKeyCode 💭Devuelve el valor entero que representa la tecla pulsada💭 |
| KeyListener | keyTyped(KeyEvent e) 💭Se ha pulsado y liberado una tecla.💭 | String getKeyText() 💭Devuelve un texto que representa el código de la tecla💭 |
| KeyListener | keyTyped(KeyEvent e) 💭Se ha pulsado y liberado una tecla.💭 | Object getSource() 💭Objeto que produjo el evento💭 |

<br></br>
## <center> Eventos del Ratón </center>

| Interface | Método |
| --- | --- |
| MouseListener | mousePressed(MouseEvent e) 💭Se ha pulsado un botón del ratón en un componente💭 |
| MouseListener | mouseReleased(MouseEvent e) 💭Se ha liberado un botón del ratón en un componente💭 |
| MouseListener | mouseClickerd(MouseEvent e) 💭Se ha pulsado y liberado un botón del ratón en un componente.💭 |
| MouseListener | mouseEntered(KeyEvent e) 💭Se ha entrado (con puntero del ratón) en un componente.💭 |
| MouseListener | mouseExited(KeyEvent e) 💭Se ha salido (con puntero del ratón) en un componente💭 |
| MouseMotionListener | mouseMoved(MouseEvent e) 💭Se mueve el puntero del ratón sobre un componente💭 |

<br></br>
Es recomendable separar la interfaz separada de la ejecución de eventos ya que será más fácil de administrar cuando tengamos varios eventos.
En la clase que acabamos de crear para manejar los eventos implementaremos la interfaz  ActionListener

```java
public class ManejadorEventos implements ActionListener
```

Ahora nos vamos al archivo VentanaPrincipal.java y en el método donde se declaran los componentes tendremos que añadir esto.

Lo que estamos haciendo es que el botón que teníamos creados este a la escucha addActionListener, para que cuando se haga click→ toda la operación la ejecutara un objeto que implemente el ActionListener en nuestro caso → ManejadorEventos y tendremos que concretar el objeto que le vamos a pasar en este caso this hace referencia a Main.java→ ventanaPrincip

```java
private void inicializarComponentes() {
  boton = new JButton("Saludar");
  boton.setBounds(50, 80, 170, 30);
  add(boton);

  boton.addActionListener(new ManejadorEventos(this));//Nuevo
}
```

Ahora tendríamos que crearnos un constructor en ManejadorEventos.java este constructor recibirá como parámetro el objeto de VentanaPrincipal.

De esta manera se podrá cambiar el titulo, acceder a la caja de texto…

```java
/*Creamos una variable que se llame ventana donde 
guardaremos los datos recibidos en el constructor,
para así utilizarlos mas tarde en otros metodos.*/

private VentanaPrincipal ventana;

public ManejadorEventos(VentanaPrincipal ventana) {
  this.ventana = ventana;
}
```

Para cambiar el titulo tendremos que utilizar el método que se nos importo al usar el implements ActionListener

```java
//Si VentanaPrincipal.java no tiene un get de cajaTexto
//tendremos que crear uno
@Override
public void actionPerformed(ActionEvent e) {
  ventana.setTitle("Hola " + ventana.getCajaTexto().getText());
}
```

Ahora creamos un botonReset para eso lo hacemos como los anteriores en VentanaPrincipal.java

```java
private JButton botonReset;

private void inicializarComponentes() {
  //añadimos un nuevo componente debajo de los anteriores
  botonReset = new JButton("Borrar");
  botonReset.setBounds(50, 120, 170, 30);
  add(botonReset);
  botonReset.addActionListener(new ManejadorEventos(this));
}
```

Ahora mismo estaríamos generando un problema ya que cuando se haga click en uno de los 2 botones que tenemos el actionPerformed de ManejadorEventos.java ejecutara el mismo código lo que tenemos que hacer crear unos if para que solo ejecute la acción que le corresponde.

Para que los if funcionen tendremos que crear los getters y setter de los botones.

‼️getSource() → Devuelve: el objeto en el que ocurrió inicialmente el evento

```java
@Override
public void actionPerformed(ActionEvent e) {
	
  if(e.getSource() == ventana.getBoton())
    ventana.setTitle("Hola " + ventana.getCajaTexto().getText());

  if (e.getSource() == ventana.getBotonReset())
    ventana.getCajaTexto().setText(""); //son lo mismo
    //ventana.getCajaTexto().setText(null); //son lo mismo
}
```

Se podría dejar así ya que funciona todo, **pero tiene un problema** y es que cada vez que hacemos click estamos creando un objeto, esto se puede solucionar creando una función para poner a la escucha los controles.

⚠️Nos vamos a la declaración de los botones y borramos la línea en la que creábamos el objeto ManejadorEventos ya que lo usaremos aquí.

```java
public void establecerManejador(ManejadorEventos manejador){
  boton.addActionListener(manejador);
  botonReset.addActionListener(manejador);		
}
```

Por ultimo iremos al Main.java y añadimos las siguientes líneas.

⚠️Hay que recalcar que ahora mismo el manejador necesita a la ventana y viceversa de tal manera que cada uno necesita una referencia al otro.

```java
public static void main(String[] args) {
  VentanaPrincipal ventanaPrincip = new VentanaPrincipal();
  ManejadorEventos manejador = new ManejadorEventos(ventanaPrincip);//Nuevo
  ventanaPrincip.establecerManejador(manejador);//Nuevo
}
```
