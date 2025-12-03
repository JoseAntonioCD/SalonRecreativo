package model;

import static model.SalaRecreativa.comprobacionPartida;
import static utils.Utils.leeEntero;

public class Jugador {
    static String nombre;
    static int identificador;
    static int creditosDisponibles = 0;
    static int partidasJugadas = 0;

    public static void  recargarCreditos() {
        int creditosARecargar = 0;
        int creditosActuales = creditosDisponibles;
        System.out.println();
       creditosARecargar = leeEntero("Introduzca la cantidad de créditos deseada a recargar:",
               "La cantidad a recargar no es entera.");
       creditosDisponibles = creditosActuales + creditosARecargar;
    }

    public static void gastarCreditos() {

    }

    public static void enseñarInformacionJugador(){
        System.out.println("Jugador: "+nombre);
        System.out.println("Identificador: "+identificador);
        System.out.println("Creditos: "+creditosDisponibles);
        System.out.println("Partidas Jugadas: "+partidasJugadas);
    }

    public static void incrementarPartidasJugadas(){
        if(comprobacionPartida()){
            partidasJugadas++;
        }
    }


}
