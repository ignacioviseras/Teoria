# Documentación

<ol>
    <li><a href="https://github.com/ignacioviseras/Teoria/blob/main/Java/2.%20Acceso%20a%20BBDD/01.%20BBDD%20Configuración%20del%20entorno.md">BBDD Configuración del entorno</a></li>
    <li><a href="https://github.com/ignacioviseras/Teoria/blob/main/Java/2.%20Acceso%20a%20BBDD/02.%20BBDD%20Conexión.md">BBDD Conexión</a></li>
    <li><a href="https://github.com/ignacioviseras/Teoria/blob/main/Java/2.%20Acceso%20a%20BBDD/03.%20Insertar%20Datos%20en%20BBDD.md">Insertar Datos en BBDD</a></li>
    <li><a href="https://github.com/ignacioviseras/Teoria/blob/main/Java/2.%20Acceso%20a%20BBDD/04.%20Listar%2C%20modificar%20y%20borrar%20en%20BBDD.md">Listar, modificar y borrar en BBDD</a></li>
    <li><a href="https://github.com/ignacioviseras/Teoria/blob/main/Java/2.%20Acceso%20a%20BBDD/05.%20Trabajo%20con%20Objetos.md">Trabajo con Objetos</a></li>
    <li><a href="https://github.com/ignacioviseras/Teoria/blob/main/Java/2.%20Acceso%20a%20BBDD/06.%20Transacciones.md">Transacciones</a></li>
    <li><a href="https://github.com/ignacioviseras/Teoria/blob/main/Java/2.%20Acceso%20a%20BBDD/07.%20Patrón%20Dao%20-%201.md">Patrón Dao - 1</a></li>
    <li><a href="https://github.com/ignacioviseras/Teoria/blob/main/Java/2.%20Acceso%20a%20BBDD/08.%20Patrón%20Dao%20-%202.md">Patrón Dao - 2</a></li>
    <li><a href="https://github.com/ignacioviseras/Teoria/blob/main/Java/2.%20Acceso%20a%20BBDD/09.%20Maven.md">Maven</a></li>

</ol>

+ Actividad para practicar los conocimientos

</br>

# AE-2. Manejo de conectores de BBDD

+ <a href="https://github.com/ignacioviseras/2-DAM/tree/main/Acceso%20a%20Datos/A2-%20Manejo%20de%20conectores%20de%20BBDD">Solución</a> de la Actividad

## **Requerimiento 1**

Se desea hacer un CRUD completo de la entidad Coche. Esta vez no se trabajará con ningún fichero y se deberá realizar la opción de modificar coche por ID. Es muy importante usar el patrón DAO visto en clase. El menú mostrado será de la siguiente forma:

- Añadir nuevo coche (El ID lo incrementará automáticamente la base de datos)
- Borrar coche por ID
- Consulta coche por ID
- Modificar coche por ID
- Listado de coches
- Terminar el programa

## **Requerimiento 2**

Se pide añadir la siguiente funcionalidad.

Los coches, tendrán asociados N pasajeros en él (habrá que crear la tabla pasajeros y hacer la relación pertinente). Los pasajeros tendrán los siguientes atributos, id, nombre, edad y peso. Se añadirá la opción “gestión de pasajeros” al programa principal, dicha opción nos mostrará un submenú como el que sigue

- Añadir nuevo pasajero
- Borrar pasajero por id
- Consulta pasajero por id
- Listar todos los pasajeros
- Añadir pasajero a coche, el programa nos pedirá un id de un pasajero y el id de un coche, y lo añadirá al coche a nivel de base de datos. Sería una buena opción mostrar todos los coches disponibles.
- Eliminar pasajero de un coche, el programa nos pedirá un id de un pasajero y el id de un coche, y lo eliminará del coche a nivel de base de datos. Sería una buena opción mostrar todos los coches y sus pasajeros asociados.
- Listar todos los pasajeros de un coche, el programa pedirá el id de un coche, y nos mostrará todos los pasajeros asociados a él.