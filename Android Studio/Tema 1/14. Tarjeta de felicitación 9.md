# 14. Tarjeta de felicitación 9

# C****ambio de activity****

---

Nosotros queremos que cuando termine la animacion del splash nos cambie a la ventana inicial para eso tenemos que.

```java
public class Splash extends AppCompatActivity implements Animation.AnimationListener{//añadir el implements

}
```

Cuando lo implementemos tendremos que añadir 3 funciones usaremos la que se llama `onAnimationEnd`

### Accionamiento de la función

En el onCreate añadimos esto para que este a la escucha, le pasaremos la misma ventana para que así podamos usar los listeners implementados anteriormente.

```java
animacion.setAnimationListener(this);
```

### ¿Cómo abrir una ventana?

```java
@Override
public void onAnimationEnd(Animation animation) {
  Intent intent = new Intent(Splash.this, MainActivity.class);//instanciamos la ventana que queremos abrir posteriormente
  startActivity(intent);//abrimos la ventana del menu
  finish();//para terminar esa accion y no se pueda acceder a ella
}
```