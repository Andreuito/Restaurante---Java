package Restaurante;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class MyTask {
    static ArrayList<Plato> listaPlatos = new ArrayList<Plato>();
    static ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
    static ArrayList<Persona> listaEmpleats = new ArrayList<Persona>();
    public static int numerador = 0;

    public static void main (String [] args) throws IOException{
        Camarero camarero = new Camarero("Andreu");
        Cocinero cocinero = new Cocinero("Aurora");
        listaEmpleats.add(camarero);
        listaEmpleats.add(cocinero);
        System.out.println(listaEmpleats.get(0).toString());
        System.out.println(listaEmpleats.get(1).toString());

        Scanner teclado = new Scanner(System.in);
        System.out.println("Cargando platos...");
        Plato.cargarPlatos();

        System.out.println("Introduce tu ID: ");
        int id = teclado.nextInt();

        for ( int i = 0; i < listaEmpleats.size(); i++){
            if(id == listaEmpleats.get(i).getId()){
                System.out.println("Bienvenido " + listaEmpleats.get(i).getNombre());
                if(listaEmpleats.get(i).getClass().getName()=="Restaurante.Camarero"){
                    System.out.println("Eres camarero");
                    System.out.println("");
                    
                    boolean menu = true;

                    while(menu == true){
                        System.out.println("Menu para camareros");
                        System.out.println("");
                        System.out.println("1. Crear pedido");
                        System.out.println("");
                        System.out.println("2. Editar pedido");
                        System.out.println("");
                        System.out.println("3. Actuar");
                        System.out.println("");
                        System.out.println("4. Sacar tickets");
                        System.out.println("");
                        System.out.println("5. Ver pendientes");
                        System.out.println("");
                        System.out.println("6. Calcular caja");
                        System.out.println("");
                        System.out.println("7. Login Cocinero");
                        System.out.println("");
                        System.out.println("8. Salir");
                        
                        int opcion = teclado.nextInt();

                        switch(opcion){
                            case 1:
                                Camarero.crearPedido();
                                break;
                            case 2:
                                Camarero.editarPedido();
                                break;
                            case 3:
                                ((Camarero) listaEmpleats.get(i)).actuar();
                                break;                             
                           case 4:
                                Camarero.sacarTicket();
                                break;
                            case 5:
                                Persona.verPendientes();
                                break;
                            case 6:
                                Persona.calcularCaja();
                                break;
                            case 7: 
                                for(int x = 0; x < listaEmpleats.size(); x++ ){
                                    if(listaEmpleats.get(x).getClass().getName()=="Restaurante.Cocinero"){
                                        System.out.println("Eres cocinero");
                                        boolean menu2 = true;
                    
                                        while(menu2 == true){
                                            System.out.println("Menu para cocineros");
                                            System.out.println("");
                                            System.out.println("1. Actuar");
                                            System.out.println("");
                                            System.out.println("2. Ver pendientes");
                                            System.out.println("");
                                            System.out.println("3. Salir");
                                            
                                            int opcion2 = teclado.nextInt();
                    
                                            switch(opcion2){
                                                case 1:
                                                    ((Cocinero) listaEmpleats.get(x)).actuar();
                                                    break;
                                                case 2:
                                                    Cocinero.verPendientes();
                                                    break;
                                                case 3:
                                                    menu2 = false;
                                                    break;
                                                default:
                                                    System.out.println("Opcion incorrecta");
                                                    break;
                                            }
                                        }
                                    }
                                }
                                break;
                            case 8:
                                menu = false;
                            break;
                            default:
                                System.out.println("Opcion incorrecta");
                                break;
                        }
                    }
                }
            }

        }
    }
}
