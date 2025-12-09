package model;

import static model.SalaRecreativa.comprobacionPartida;
import static utils.Utils.leeEntero;

public class Jugador {
    static String nombre;
    static int identificador;
    static int creditosDisponibles = 0;
    static int partidasJugadas = 0;
    static boolean creditosSuficientes = false;

    public static void recargarCreditos() {
        int creditosARecargar = 0;
        int creditosActuales = creditosDisponibles;
        System.out.println();
        creditosARecargar = leeEntero("Introduzca la cantidad de créditos deseada a recargar:",
                "La cantidad a recargar no es entera.");
        creditosDisponibles = creditosActuales + creditosARecargar;
    }

    public static boolean comprobacionCreditos(int creditosActuales, int creditosAGastar) {
        if (creditosActuales < creditosAGastar) {
            creditosSuficientes = false;
            System.out.println("CRÉDITOS INSUFICIENTES. RECARGUE");
        }
        return creditosSuficientes;
    }

    public static void gastarCreditos(String msj, String msjError, int creditosAGastar, int creditosActuales) {
        System.out.println(msj);
        creditosAGastar = leeEntero("", "");
        if (creditosDisponibles < creditosAGastar) {
            System.out.println(msjError);
        } else {
            creditosDisponibles = creditosActuales - creditosAGastar;
        }
    }

    public static void enseñarInformacionJugador() {
        System.out.println("Jugador: " + nombre);
        System.out.println("Identificador: " + identificador);
        System.out.println("Creditos: " + creditosDisponibles);
        System.out.println("Partidas Jugadas: " + partidasJugadas);
    }

    public static void incrementarPartidasJugadas() {
        if (comprobacionPartida()) {
            partidasJugadas++;
        }
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        Jugador.nombre = nombre;
    }

    public static int getIdentificador() {
        return identificador;
    }

    public static void setIdentificador(int identificador) {
        Jugador.identificador = identificador;
    }

    public static int getCreditosDisponibles() {
        return creditosDisponibles;
    }

    public static void setCreditosDisponibles(int creditosDisponibles) {
        Jugador.creditosDisponibles = creditosDisponibles;
    }

    public static int getPartidasJugadas() {
        return partidasJugadas;
    }

    public static void setPartidasJugadas(int partidasJugadas) {
        Jugador.partidasJugadas = partidasJugadas;
    }

    public Jugador(String nombre, int identificador, int creditosDisponibles, int partidasJugadas) {
        this.nombre = nombre;
        this.creditosDisponibles = creditosDisponibles;
        this.identificador = identificador;
        this.partidasJugadas = partidasJugadas;
    }
}
