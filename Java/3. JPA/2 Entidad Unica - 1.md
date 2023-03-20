# 2. Entidad Unica - 1

# Pom.xml

```xml
<properties>
  <maven.compiler.target>1.8</maven.compiler.target>
  <maven.compiler.source>1.8</maven.compiler.source>
</properties>

<dependencies>
  <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
  <dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  <version>8.0.18</version>
  </dependency>

  <!-- https://mvnrepository.com/artifact/org.eclipse.persistence/eclipselink -->
  <dependency>
  <groupId>org.eclipse.persistence</groupId>
  <artifactId>eclipselink</artifactId>
  <version>2.7.7</version>
  </dependency>

</dependencies>
```

# Beans

## @Entity

Se utiliza para indicar que una clase es una entidad y que se debe mapear a una tabla en una base de datos relacional.

(El nombre de la tabla en la bd será el mismo que el de la clase)

```java
@Entity
public class Persona{

}
```

## @Table(name = “personas”)

Se utiliza para indicar el nombre de la tabla a la que corresponde ese archivo.

```java
@Entity
@Table(name = "personas")
public class Persona{

}
```

## @Id

Al colocar esto encima de una variable estamos convirtiendo esa variable en clave primaria

```java
@Id
private int id;
```

## @GeneratedValue(strategy = GenerationType.IDENTITY)

Al colocar esta anotación estamos autoincrementando el valor del id.

Lo cual no tendríamos que pasar ese dato al crear registro.

```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
```

# persistance.xml

## Formato

- name → indicamos el nombre del proyecto

```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.1" xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd">
  <persistence-unit name="Teoria_JPA" transaction-type="RESOURCE_LOCAL">

  </persistence-unit>
</persistence>
```

## Beans

- Cada beans que necesitemos comunicar con la bd lo tendremos que añadir

```xml
<class>modelo.entidad.Persona</class>
```

## Conexión con la bd

1. Indicamos el driver de conexión.
2. Indicamos la bd.
3. Indicamos el user para conectarnos a la bd

```xml
<properties>
  <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
  <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/bd_persona"/>
  <property name="javax.persistence.jdbc.user" value="root"/>
	
</properties>
```