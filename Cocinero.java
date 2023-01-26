package Restaurante;

import java.util.Scanner;

public class Cocinero extends Persona {

    public Cocinero(String nombre) {
        super(nombre);
    }

    public void actuar() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Actualizar pedido");

        // ver pedidos
        if (MyTask.listaPedidos.size() == 0) {
            System.out.println("No hay pedidos");
            return;
        } else {
            System.out.println("Pedidos disponibles: ");
            for (int i = 0; i < MyTask.listaPedidos.size(); i++) {
                System.out.println(MyTask.listaPedidos.get(i));
            }
        }

        System.out.println("Pedido a actualizar");
        int id = teclado.nextInt();
        for (int x = 0; x < MyTask.listaPedidos.size(); x++) {
            if (id == MyTask.listaPedidos.get(x).getId()) {
                System.out.println("Pedido encontrado");
                System.out.println("Lineas del pedido a mostrar");

                // ver las lineas del pedido de ese pedido
                for (int y = 0; y < MyTask.listaPedidos.get(x).getLineasPedido().size(); y++) {
                    System.out.println(MyTask.listaPedidos.get(x).getLineasPedido().get(y));
                }
                System.out.println("Seleccionar linea: ");
                int idLinea = teclado.nextInt();
                for (int z = 0; z < MyTask.listaPedidos.get(x).getLineasPedido().size(); z++) {
                    if (MyTask.listaPedidos.get(x).getLineasPedido().get(z).getId() == idLinea) {
                        System.out.println("Avanzando estado de linea");
                        String estado = ((LineaPedido) MyTask.listaPedidos.get(x).getLineasPedido().get(z)).getEstado();
                        if (estado == "Pedido") {
                            ((LineaPedido) MyTask.listaPedidos.get(x).getLineasPedido().get(z)).setEstado("Cocina");
                        }
                        if (estado == "Cocina") {
                            ((LineaPedido) MyTask.listaPedidos.get(x).getLineasPedido().get(z)).setEstado("Listo");
                        }
                    }
                }
            }
        }

    }

    public static void verPendientes() {
        
        if (MyTask.listaPedidos.size() == 0) {
            System.out.println("No hay pedidos pendientes");
        } else {
            System.out.println("Pedidos disponibles: ");
            for (int i = 0; i < MyTask.listaPedidos.size(); i++) {
                System.out.println("llega?");
                for (int x = 0; x < (int) MyTask.listaPedidos.get(i).getLineasPedido().size(); x++) {
                    if (MyTask.listaPedidos.size() == 0) {
                        System.out.println("No hay pedidos pendientes");
                    } else {
                        System.out.println("Pedidos pendientes: ");
                        if (((LineaPedido) MyTask.listaPedidos.get(i).getLineasPedido().get(x)).getEstado() == "Pedido"
                                || ((LineaPedido) MyTask.listaPedidos.get(i).getLineasPedido().get(x))
                                        .getEstado() == "Cocina") {
                            System.out.println(MyTask.listaPedidos.get(i).getLineasPedido().get(x));
                        }
                    }
                }
            }
        }
    }
}
