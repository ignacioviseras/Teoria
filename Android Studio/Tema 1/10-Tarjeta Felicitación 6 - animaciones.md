# 10. Tarjeta Felicitación 6-animaciones

Ahora vamos a hacer lo que es llamado animación slide up, para eso hacemos lo siguiente.

<p align="center">
  <img src="fotos/41.png">
</p>

En el archivo que nos creamos para hacer la animación aparecerá lo siguiente.

```java
<scale
  android:pivotY="100%"
  android:pivotX="50%"
  android:fromXScale="1"
  android:fromYScale="0"
  android:toXScale="1"
  android:toYScale="1"
  android:duration="1000" />
```

⚠️Como tenemos la otra animación pondremos un delay para que espere⚠️

```java
<set xmlns:android="http://schemas.android.com/apk/res/android"
  android:startOffset="3500">
```

Activación de la animación en el .java

```java
TextView subtitulo1 = (TextView) findViewById(R.id.subtitulo1);
TextView subtitulo2 = (TextView) findViewById(R.id.subtitulo2);
Animation animSubTitulos = AnimationUtils.loadAnimation(this, R.anim.slideup);
subtitulo1.startAnimation(animSubTitulos);
subtitulo2.startAnimation(animSubTitulos);
```