package model;

import static model.Jugador.*;
import static model.MaquinaArcade.*;
import static utils.Utils.generarNumeroAleatorio;

public class SalaRecreativa {
    private static Jugador jugadores[];
    private static MaquinaArcade[] maquinas;
    private static int contadorMaquinas;
    private static int contadorJugadores;

    public static int generarPuntuacion() {
        int puntuacion = 0;
        puntuacion = generarNumeroAleatorio(0, 999);
        return puntuacion;
    }

    public static boolean comprobarCreditos(int creditos, int creditosNecesarios) {
        boolean creditosSuficientes = false;
        if (creditos >= creditosNecesarios) {
            creditosSuficientes = true;
        } else {
            System.out.println("Le hace falta " + (creditosNecesarios - creditos) + " créditos. Recargue sus créditos si desea continuar jugando");
        }
        return creditosSuficientes;
    }

    public static void descontarCreditos() {
        gastarCreditos("Precio de partida = " + precioPartida, "ERROR", precioPartida, creditosDisponibles);
    }

    public static void mensajePartida() {
        System.out.println("SU PUNTUACION ES DE: " + generarPuntuacion());
    }

    public static boolean comprobacionPartida() {
        boolean haJugado = false;

        return haJugado;
    }

    public static void setJugadores(Jugador jugadores) {
        SalaRecreativa.jugadores = new Jugador[]{jugadores};
    }

    public boolean annadirMaquina(MaquinaArcade nueva) {

        if (contadorMaquinas >= maquinas.length) {
            System.out.println("No hay espacio para más máquinas.");
            return false;
        }

        maquinas[contadorMaquinas] = nueva;
        contadorMaquinas++;

        System.out.println("Máquina añadida al salón correctamente.");
        return true;
    }

    // Método opcional para ver todas las máquinas
    public static void listarMaquinas() {
        System.out.println("=== Máquinas en el salón ===");
        for (int i = 0; i < contadorMaquinas; i++) {
            System.out.println((i + 1) + ". " + maquinas[i].getNombre());
        }
    }

    public static void listarMaquinasActivas(){
        if(activo){

        }
    }

    public static void gestionarPartida() {
        consultarEstadoMaquina();
        if (activo) {
            comprobacionCreditos(creditosDisponibles, precioPartida);
            if (creditosSuficientes) {
                gastarCreditos("", "", precioPartida, creditosDisponibles);
                jugarPartida();
            } else {
                System.out.println("===CREDITOS INSUFICIENTES. RECARGUE CRÉDITOS===");
            }
        } else {
            System.out.println("===MAQUINA EN MANTENIMIENTO===");
        }
    }


    public static void listarJugadores() {
        System.out.println("=== Jugadores registrados ===");
        for (int i = 0; i < contadorJugadores; i++) {
            System.out.println((i + 1) + ". " + jugadores[i].getNombre());
        }
    }

}
