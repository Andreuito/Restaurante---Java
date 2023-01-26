# Restaurante Java

Vamos a realizar una aplicación para un restaurante.

Clase Plato (0,1 Punts)
int id (autoincremental)
String nombre
float precio
metodo cargarPlatos() Lee los platos de “platos.txt” y los añade al array de platos que dispone el main del programa. Debe comprobar que no exista un Plato con el mismo nombre en el array, en caso de ya existir, actualizará el precio. (1,5 Puntos)

En “platos.txt” cada plato corresponde a una línea separados por saltos de línea, y el nombre y el precio de cada plato está separado por “;”

Clase LineaPedido (0,1 Puntos)
int id (autoincremental)
Plato plato
String estado (pedido, cocina, listo, servido)
int cantidad

Clase Pedido (0,1 Puntos)
int id (autoincremental)
int mesa
Array lineaPedido

Clase Persona abstracta (0,1 Puntos)
int id (autoincremental)
String nombre
método verPendientes() Muestra todas las líneas de pedido con estado pedido, cocina o listo (1 Punto)
metodo actuar() Abstracto (0,6 Puntos)
método calcularCaja() Calcula la suma total de los precios de todos los pedidos (1 Punto)

Clase Cocinero
método verPendientes() Muestra las líneas de pedido que están en estado de pedido o cocina. (0,5 Puntos)
metodo actuar() Permite seleccionar por id una línea de Pedido y avanzar su estado de pedido->cocina o de cocina->listo (1 Punto)

Clase Camarero
método crearPedido() Permite crear un nuevo pedido con al menos una línea de pedido (1 Punto)
método editarPedido() Permite añadir una linia de pedido a un pedido (1 Punto)
metodo actuar()  Permite seleccionar por id una línea de Pedido y avanzar su estado de  listo->servido (0,5 Puntos)
metodo sacarTicket() Calcula el precio total de un pedido según una id (0,5 Puntos)

El programa deberá tener un MyTask (main) que muestre un menú que nos pregunte nuestro id. Y mostrarnos un menú que nos permita realizar las acciones según el empleado correspondiente. El programa principal dispondrá de un Array de Platos, un Array de Pedidos y un Array de Empleados (Camareros + Cocineros). (1,5 Puntos)
