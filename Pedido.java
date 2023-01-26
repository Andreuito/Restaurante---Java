package Restaurante;

import java.util.ArrayList;

public class Pedido {
    private int id;
    private int mesa;
    private ArrayList <LineaPedido> lineasPedido = new ArrayList <LineaPedido>();
    private static int contadorpedidos = 0;

    //setters i getters

    public int getId() {
        return id;
    }

    public void setId() {
        contadorpedidos++;
        this.id = contadorpedidos;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public ArrayList <LineaPedido> getLineasPedido() {
        return lineasPedido;
    }

    public void setLineasPedido(ArrayList <LineaPedido> lineasPedido) {
        this.lineasPedido = lineasPedido;
    }

    public static int getContadorpedidos() {
        return contadorpedidos;
    }

    //constructor

    public Pedido(){
        this.id = 0;
        this.mesa = 0;
        this.lineasPedido = new ArrayList <LineaPedido>();
    }

    public Pedido(int mesa, ArrayList <LineaPedido>lineasPedido) {
        this.setId();
        this.setMesa(mesa);
        this.setLineasPedido(lineasPedido);
    }

    //metodos
    
    @Override
    public String toString() {
        return "Pedido [id=" + id + ", mesa=" + mesa + ", lineasPedido=" + lineasPedido + ']';
    }
}
