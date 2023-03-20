# 4. Relaciones

# @Entity

Indicamos que la clase es una entidad a persistir

```java
@Entity
public class Pedido {
}
```

# @Table(name=”clientes”)

Indicamos el nombre que tendrá la tabla donde guardaremos los datos.

```java
@Entity
@Table(name = "clientes")
public class Cliente {
}
```

# @Id

Se aplica a una variable y estaremos indicando que esta será la clave primaria en la tabla de la base de datos

```java
@Id
private Integer id;
```

# @GeneratedValue(strategy = GenerationType.IDENTITY)

Indicamos que la clave primaria se generará automáticamente

```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
```

# @Temporal(TemporalType.Date)

Indicamos como será el formato del campo que se enviara a la bd

| Nombre | Uso | Ejemplo |
| --- | --- | --- |
| TemporalType.DATE | solo fecha | 2021-02-07 |
| TemporalType.TIME | solo hora | 20:44:34 |
| TemporalType.TIMESTAMP | fecha y hora | 2021-02-07 20:44:34 |

```java
@Temporal(TemporalType.DATE)
private Date fechaNacimiento;
```

# @Column(name = "numero_cuenta")

Indicamos el nombre de la columna de la base de datos en la que se persistirá los datos.

```java
@Column(name = "numero_cuenta")
private Integer numeroTC;
```