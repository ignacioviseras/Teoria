# 8. Relaciones Many To Many

# @ManyToMany

Esta anotación indica que la relación entre las entidades es de “muchos a muchos”. 

Nos crea una tabla intermedia con las FK y PK de las otras tablas (no podremos modificar los datos de esta tabla)

### Cliente

```java
@ManyToMany(mappedBy="clientes", cascade=CascadeType.PERSIST) 
private List<Comercial> comerciales;
```

### Comercial

- name → El nombre de la tabla intermedia
- joinColumns → Las columnas FK y PK que aporta esta entidad (COMERCIAL)
- inverseJoinColumns → Las columnas FK y PK que me aporta la otra Entidad (CLIENTE)
    1. FK que aporta Comercial
    2. FKs que aportan el resto de entidades

```java
@ManyToMany(cascade=CascadeType.PERSIST)
@JoinTable(name="comerciales_clientes",
joinColumns= { @JoinColumn(name="fk_id_comercial", referencedColumnName="id") },//1
inverseJoinColumns= { @JoinColumn(name="fk_id_cliente", referencedColumnName="id")})//2
private List<Cliente> clientes;
```