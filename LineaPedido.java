package Restaurante;

public class LineaPedido {
    private int id;
    private Plato plato;
    private String estado;
    private int cantidad;
    private static int contadorlp = 0;

    //setters i getters

    public int getId() {
        return id;
    }

    public void setId() {
        contadorlp++;
        this.id = contadorlp;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public static int getContadorlp() {
        return contadorlp;
    }

    //constructor

    public LineaPedido() {
        this.id = 0;
        this.plato = new Plato();
        this.estado = "";
        this.cantidad = 0;
    }

    public LineaPedido(Plato plato, String estado, int cantidad) {
        this.setId();
        this.setPlato(plato);
        this.setEstado(estado);
        this.setCantidad(cantidad);
    }

    //metodos

    @Override
    public String toString() {
        return "LineaPedido{" + "id=" + id + ", plato=" + plato + ", estado=" + estado + ", cantidad=" + cantidad + '}';
    }
}
