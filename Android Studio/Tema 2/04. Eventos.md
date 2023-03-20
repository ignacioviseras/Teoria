# 4. Eventos

Ahora vamos a realizar el cambio de una activity a otra

## Login.java

Tengo que comentar que si vamos a tener muchos botones el mejor sacarlo fuera del onCreate

```java
public class Login extends AppCompatActivity {

  Button botonLogin;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    getSupportActionBar().hide();//borramos la barra de arriba

//**********botones**********
    botonLogin = findViewById(R.id.botonLogin);
    botonLogin.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //indicamos que va a pasar de la ventana en la que estamos this a la ventana del main
        Intent intent = new Intent(Login.this, MainActivity.class);
        startActivity(intent);
      }
    });

  }

}
```

## MainActivity.java

```java
public class Login extends AppCompatActivity {

  Button botonLogin;
  TextView botonRegistro;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    getSupportActionBar().hide();

    botonLogin = findViewById(R.id.botonLogin);
    botonLogin.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Login para firebase
        Intent intent = new Intent(Login.this, MainActivity.class);
        startActivity(intent);
      }
    });

    botonRegistro = findViewById(R.id.botonRegistro);
    botonRegistro.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Crear usuario en la base de datos
        Intent intent = new Intent(Login.this, MainActivity.class);
        startActivity(intent);
      }
    });
        
  }

}
```