# 5. Relaciones Embebidas

# @Embedded

Con esta anotación que se localizara en el beans de otra clase, estaremos incrustando todos los datos de **dirección** en la tabla **clientes** (en la base de datos)

| Clientes | id  | nombre  | telefono  | datosBancarios  | tipoVia  | nombreVia  | ciudad |
| --- | --- | --- | --- | --- | --- | --- | --- |

```java
@Embedded
private Direccion direccion;
```

# @Embeddable

Como los atributos de la clase van a formar parte de los campos de otra tabla (tabla Cliente) usaremos la anotación @Embeddable (en la cabecera de la clase)

```java
@Embeddable
public class Direccion {
```