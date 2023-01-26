package Restaurante;

import java.util.*;

public class Camarero extends Persona {

    public Camarero(String nombre) {
        super(nombre);
    }

    public static void crearPedido() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Creando pedido...");
        System.out.println("Plato deseado (id):");
        int plate = teclado.nextInt();
        System.out.println("Introduzca la cantidad: ");
        int cantidad = teclado.nextInt();
        System.out.println("Introduzca la mesa: ");
        int mesa = teclado.nextInt();
        
        boolean encontrado = false;
        int i = 0;
        while (encontrado == false && i < MyTask.listaPlatos.size()) {
            if (plate == MyTask.listaPlatos.get(i).getId()) {
                System.out.println("Plato encontrado");
                Plato plato = new Plato(MyTask.listaPlatos.get(i).getNombre(), MyTask.listaPlatos.get(i).getPrecio());
                LineaPedido lineaPedido = new LineaPedido(plato, "Pedido", cantidad);
                ArrayList <LineaPedido> lineasPedido = new ArrayList <LineaPedido>();
                lineasPedido.add(lineaPedido);
                Pedido pedido = new Pedido(mesa, lineasPedido);
                MyTask.listaPedidos.add(pedido);
                System.out.println("Pedido creado");
                encontrado = true;
            }else{
                i++;
            }
            
        }

    }

    public static void editarPedido(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Editar pedido");

        for(int i = 0; i < MyTask.listaPedidos.size(); i++){
            System.out.println(MyTask.listaPedidos.get(i));
        }

        System.out.println("Introduzca el id del pedido a editar: ");
        int id = teclado.nextInt();
        for(int x = 0; x < MyTask.listaPedidos.size(); x++){
            if(MyTask.listaPedidos.get(x).getId() == id){
                System.out.println("Introduzca el id del plato a editar: ");
                int id_plato = teclado.nextInt();
                System.out.println("Introduzca la cantidad: ");
                int cantidad = teclado.nextInt();
                boolean encontrado = false;
                int i = 1;

                while(encontrado == false && i < MyTask.listaPlatos.size()){
                    if(id_plato == MyTask.listaPlatos.get(i).getId()){
                        Plato plato = new Plato(MyTask.listaPlatos.get(i).getNombre(), MyTask.listaPlatos.get(i).getPrecio());
                        LineaPedido lineaPedido = new LineaPedido(plato, "Pedido", cantidad);
                        MyTask.listaPedidos.get(x).getLineasPedido().add(lineaPedido);
                        System.out.println("Pedido editado");
                        encontrado = true;
                    }else{
                        i++;
                    }
                }

            }
        }
    }


    public void actuar(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Actualizar pedido");

        System.out.println("Pedidos disponibles");
        for(int i = 0; i < MyTask.listaPedidos.size(); i++){
            System.out.println(MyTask.listaPedidos.get(i));
        }

        System.out.println("Introduzca el id del pedido a actualizar: ");
        int id = teclado.nextInt();
        for(int x = 0; x < MyTask.listaPedidos.size(); x++){
            if (MyTask.listaPedidos.get(x).getId() == id){
                System.out.println("Pedido encontrado");
                System.out.println("Linea a pedido a mostrar");

                for(int i = 0; i < MyTask.listaPedidos.get(x).getLineasPedido().size(); i++){
                    System.out.println(MyTask.listaPedidos.get(x).getLineasPedido().get(i));
                }

                System.out.println("Seleccione la linea:");
                int linea = teclado.nextInt();
                for(int z = 0; z < MyTask.listaPedidos.get(x).getLineasPedido().size(); z++){
                    if(linea == ((LineaPedido) MyTask.listaPedidos.get(x).getLineasPedido().get(z)).getId()){
                        System.out.println("Avanzando estado...");
                        String estado = ((LineaPedido) MyTask.listaPedidos.get(x).getLineasPedido().get(z)).getEstado();
                        if(estado == "Listo"){
                            ((LineaPedido) MyTask.listaPedidos.get(x).getLineasPedido().get(z)).setEstado("Servido");
                        }
                    }
                }
            }
        }
    }

    public static void sacarTicket () {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Sacar ticket");
        System.out.println("Introduzca el id del pedido: ");
        int id = teclado.nextInt();
        int a = 0;

        for(int i = 0; i < MyTask.listaPedidos.size(); i++) {
            if(MyTask.listaPedidos.get(i).getId() == id){
                for(int x = 0; x < MyTask.listaPedidos.get(i).getLineasPedido().size(); x++){
                    int b = (int) ((LineaPedido) MyTask.listaPedidos.get(i).getLineasPedido().get(x)).getPlato().getPrecio();
                    int c = (int) ((LineaPedido) MyTask.listaPedidos.get(i).getLineasPedido().get(x)).getCantidad();
                    int d = b * c;
                    a = a + d;
                }
            }
        }
        System.out.println("El total es: " + a);
    }

}
