# 7. Relaciones One To Many

# @OneToMany

Esta anotación indica que la relación entre las entidades es de “uno a muchos”. (un cliente puede tener muchos pedidos)

> Esta anotación para las **relaciones bidireccionales ES OBLIGATORIA** en la que tiene la FK (la clase pedido)-
> 

### Clase cliente

```java
@OneToMany(mappedBy = "cliente", cascade=CascadeType.ALL)
private List<Pedido> pedidos;
```

### Clase Pedido

Usando la etiqueta @ManyToOne estaremos haciendo una relación unidireccional

```java
@ManyToOne
@JoinColumn(name="fk_id_cliente", referencedColumnName = "id")
private Cliente cliente;
```