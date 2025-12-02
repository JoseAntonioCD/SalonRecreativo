package model;

import static utils.Utils.generarNumeroAleatorio;
import static utils.Utils.pideEnteroAcotado;

public class MaquinaArcade {
   static String nombre;
    static String genero;
    static int precioPartida;
    static boolean activo = true;
    static int partidasJugadas = 0;
    static int [] ranking = new int[10];
    static int [] rankingTop3 = new int[3];
    static String [] top3Jugadores = new String[3];

    public static void manejoMaquina(){
        int opcion = 0;

        opcion = pideEnteroAcotado("Introduzca 1 para activar la máquina, 2 para desactivarla y 0 para salir:",
                "Debe introducir un número entre 0 y 2",0,2);
        switch (opcion){
            case 1:
                activo = true;
                break;
            case 2:
                activo = false;
                break;
            default:
                break;
        }
    }

    public static void consultarEstadoMaquina(){
        if(activo == true){
            System.out.println("La máquina está activa y funcional");
        }else{
            System.out.println("La máquina está bajo mantenimiento");
        }
    }

    public static void jugarPartida(){
        generarNumeroAleatorio(0,999);
    }
}
