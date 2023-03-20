# 12. Borrar datos y Logout

### **BorrarTarea**

1. El view hace referencia al botón q ha sido pulsado
2. Pillamos del botón el padre y necesitamos castearlo
3. Ahora a raíz del padre podemos pillar el textView usando el findByid
4. texto de la tarea
5. Posición de la tarea en la lista
6. Pillamos de la bd Tareas, y buscamos el documento con el identificador del id q pasamos para así poder borrarlo

```java
public void borrarTarea(View view){//1
  View parent = (View) view.getParent();//2
  TextView tareaTextView = parent.findViewById(R.id.nombreTarea);//3
  String tarea = tareaTextView.getText().toString();//4
  int posicion = listaTareas.indexOf(tarea);//5
  db.collection("Tareas").document(listaIdTareas.get(posicion)).delete();//6
}
```

Para que este metodo se pueda ejecutar tenemos que colocar en el xml del boton el llamamiento al metodo

```xml
android:onClick="borrarTarea"
```

### Logout

```java
case R.id.logout:
  //cierre de session firebase
  mAuth.signOut();//desloguea
  onBackPressed();//vuelve a la pestaña anterior
  finish();	
  return true;
```