package Restaurante;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Plato {
    private int id;
    private String nombre;
    private float precio;
    private static int contadorplatos = 0;

    //setters i getters

    public int getId() {
        return id;
    }
    
    public void setId() {
        contadorplatos++;
        this.id = contadorplatos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public static int getContadorplatos() {
        return contadorplatos;
    }

    //constructor

    public Plato(){
        this.id = 0;
        this.nombre = "";
        this.precio = 0;
    }

    public Plato(String nombre, float precio) {
        this.setId();
        this.setNombre(nombre);
        this.setPrecio(precio);
    }

    //metodos

    @Override
    public String toString() {
        return "Plato [id= " + id + ", nombre= " + nombre + ", precio= " + precio + ']';
    }

    public static void cargarPlatos() throws IOException{
        try {
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get("C:\\Users\\Andreu\\Documents\\Clase\\Programació\\Java\\Restaurante\\platos.txt")));
            for (int i = 0; i < lines.size(); i++) {
                String[] pasador = lines.get(i).split(";");
                boolean encontrado = false;
                    if(i == 0){
                    Plato plato = new Plato (pasador[0], Float.parseFloat(pasador[1]));
                        MyTask.listaPlatos.add(plato);
                }else{
                    while(encontrado == false){
                        for(int x = 0; x < MyTask.listaPlatos.size(); x++){
                            if(MyTask.listaPlatos.get(x).getNombre().equals(pasador[0])){
                                MyTask.listaPlatos.get(x).setPrecio(Float.parseFloat(pasador[1]));
                                encontrado = true;
                                break;
                            }
                        }
                        if(encontrado == false){
                            Plato plato = new Plato (pasador[0], Float.parseFloat(pasador[1]));
                            MyTask.listaPlatos.add(plato);
                            encontrado = true;
                        }
                    }
                }
            }
            for(int i = 0; i < MyTask.listaPlatos.size(); i++){
                System.out.println(MyTask.listaPlatos.get(i));
            }
            System.out.println("Platos cargados");
            
        } catch (IOException e) {
            System.out.println("Error al cargar los platos");
        }
    }
}
