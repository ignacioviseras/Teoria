# 6. Cuadros de dialogo

Vamos a crear un dialog con 2 botones

<table>
	<tbody>
		<tr>
			<td colspan="4"><h5>Es importante darle</h5></td>
		</tr>
		<tr>
			<td colspan="2">• Un titulo</td>
			<td colspan="2" rowspan="6"><img src="fotos/14.png"></td>
		</tr>
		<tr>
			<td colspan="2">• Un mensaje</td>
		</tr>
		<tr>
			<td colspan="2">• La caja de texto</td>
		</tr>
		</tr>
			<td colspan="2">• Opciones a los botones</td>
		</tr>
		<tr>
			<td>Cancelar</td>
			<td>Añadir</td>
		</tr>
	</tbody>
</table>


```java
//activar dialogo para añadir tarea
final EditText taskEditText = new EditText(this);
AlertDialog dialog = new AlertDialog.Builder(this)
    .setTitle("Nuevo tarea")
    .setMessage("¿Que quieres?")
    .setView(taskEditText)
      .setPositiveButton("Añadir", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
          //añadir tarea a la base de datos

          /*no se puede poner esto aqui ya que estamos fuera del contexto
          * la mejor solucion es llamar a un metodo que tenga el toast
          *
          * Toast.makeText(this, "Tarea añadida", Toast.LENGTH_LONG).show();
          */
        }
      })
      .setNegativeButton("Cancelar", null)
      .create();
//para mostrar el dialogo hacemos esto
dialog.show();

//Toast.makeText(MainActivity.this, "Tarea añadida", Toast.LENGTH_LONG).show();
return true;
```

### Acción Logout

Para que cuando nos deslogueemos, nos retorne al inicio tenemos

```java
startActivity(new Intent(MainActivity.this, Login.class));
```