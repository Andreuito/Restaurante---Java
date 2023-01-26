package Restaurante;

public abstract class Persona {
    private int id;
    private String nombre;
    private static int contadorPersonas = 0;

    //seters i getters

    public int getId() {
        return id;
    }

    public void setId() {
        contadorPersonas++;
        this.id = contadorPersonas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static int getContadorPersonas() {
        return contadorPersonas;
    }

    // constructores


    public Persona(){
        this.id = 0;
        this.nombre = "";
    }

    public Persona(String nombre) {
        this.setId();
        this.setNombre(nombre);
    }


    //metodos
    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + '}';
    }

    public static void verPendientes(){
       for(int i = 0; i < MyTask.listaPedidos.size(); i++){
            for(int x = 0; x < (int) MyTask.listaPedidos.get(i).getLineasPedido().size(); x++){
                if(((LineaPedido) MyTask.listaPedidos.get(i).getLineasPedido().get(x)).getEstado() == "Pedido" || ((LineaPedido) MyTask.listaPedidos.get(i).getLineasPedido().get(x)).getEstado() == "Cocina" || ((LineaPedido) MyTask.listaPedidos.get(i).getLineasPedido().get(x)).getEstado() == "Listo") {
                    System.out.println(MyTask.listaPedidos.get(i).getLineasPedido().get(x));
                }
            }
       }

    }

    public static void calcularCaja(){
        int total = 0;
        for(int i = 0; i < MyTask.listaPlatos.size(); i++){
            for(int x = 0; x < MyTask.listaPedidos.size(); x++){
                if(i == MyTask.listaPedidos.get(x).getId()){  
                    for(int y = 0; y < MyTask.listaPedidos.get(x).getLineasPedido().size(); y++){
                        int a = (int) ((LineaPedido) MyTask.listaPedidos.get(x).getLineasPedido().get(y)).getPlato().getPrecio();
                        int b = (int) ((LineaPedido) MyTask.listaPedidos.get(x).getLineasPedido().get(y)).getCantidad();
                        int c = a * b;
                        total = total + c;
                    }
                }
            }
        }
        System.out.println("El total de la caja es: " + total);
    }

    public abstract void actuar();
}
