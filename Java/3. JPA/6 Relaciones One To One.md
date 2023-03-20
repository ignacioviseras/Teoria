# 6. Relaciones One To One

# @OneToOne

Usaremos esta anotación que usamos para indicar una relación "uno a uno”. 

| Nombre | Uso |
| --- | --- |
| mappedBy | Hay que decirle con cual de todos los posibles atributos de tipo cliente que tiene la clase DatosBancarios, es el con el que nos estamos relacionando (en este caso solo hay uno) |
| cascade | Representan como deben de comportarse los objetos a los cuales estamos referenciado desde este objeto |

## CascadeType

| CascadeType | Uso |
| --- | --- |
| ALL | Siempre que hagamos cualquier acción sobre un cliente, reaccionamos de igual manera con sus datos bancarios.

Ejemplo si borramos un cliente borramos sus datos bancarios asociados, si damos de alta un cliente, daremos también de alta sus datos bancarios asociados. |
| PERSIST | Solo en caso que demos de ALTA un cliente daremos de alta sus datos bancarios |
| REMOVE | Solo en caso que demos de BAJA un cliente daremos de baja sus datos bancarios |

- Si lo ponemos en una sola clase es **OBLIGATORIO** ponerla en el lado que tenga la **Foreign Key**
- Si colocamos la anotación @OneToOne en las 2 clases ambas entidades se ven.
    
    En ese caso tendremos que especificar quien tiene la Foreign Key usando la anotación @JoinColumn
    
    ```java
    @OneToOne(mappedBy = "cliente", cascade=CascadeType.ALL)
    private DatosBancarios datosBancarios;
    ```
    

# @JoinColumn

- name → Le damos nombre a la columna
- referencedColumnName → decimos a que columna de la tabla clientes hacemos referencia.

```java
@JoinColumn(name = "fk_id_cliente", referencedColumnName = "id")
private Cliente cliente;
```