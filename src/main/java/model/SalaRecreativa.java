package model;

import static utils.Utils.generarNumeroAleatorio;

public class SalaRecreativa {
    int [] jugadores;
    int [] maquinasArcade;

    public static int generarPuntuacion(){
        int puntuacion = 0;
        puntuacion = generarNumeroAleatorio(0,999);
        return puntuacion;
    }

    public static boolean comprobarCreditos(int creditos, int creditosNecesarios){
        boolean creditosSuficientes = false;
        if(creditos>=creditosNecesarios){
            creditosSuficientes = true;
        }else{
            System.out.println("Le hace falta "+(creditosNecesarios - creditos)+" créditos. Recargue sus créditos si desea continuar jugando");
        }
        return creditosSuficientes;
    }

    public static void descontarCreditos(int creditos, int creditosADescontar, int creditosRestantes){
        creditosRestantes = creditos - creditosADescontar;
    }

    public static void mensajePartida(){
        System.out.println("SU PUNTUACION ES DE: "+generarPuntuacion());
    }

    public static boolean comprobacionPartida(){
        boolean haJugado = false;

        return haJugado;
    }
}
