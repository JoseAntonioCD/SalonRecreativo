package model;

import static utils.Utils.leeEntero;
import static utils.Utils.pideEnteroAcotado;

public class Jugador {

    private String nombre;
    private int identificador;
    private int creditosDisponibles = 0;
    private int partidasJugadas = 0;

    public Jugador(String nombre, int identificador) {
        this.nombre = nombre;
        this.identificador = identificador;
    }


    public static void recargarCreditosJugador() {
        SalaRecreativa.listarJugadores();
        int id = pideEnteroAcotado("Introduce ID del jugador:", "ID no válido", 0, 99999);

        Jugador jugador = SalaRecreativa.buscarJugadorPorId();
        if(jugador != null) {
            recargarCreditosJugador();
        } else {
            System.out.println("Jugador no encontrado.");
        }
    }

    public boolean comprobacionCreditos(int precioPartida) {
        return creditosDisponibles >= precioPartida;
    }

    public void gastarCreditos(int precioPartida) {
        creditosDisponibles -= precioPartida;
    }

    public void incrementarPartidasJugadas() {
        partidasJugadas++;
    }


    public void enseñarInformacionJugador() {
        System.out.println("Jugador: " + nombre);
        System.out.println("ID: " + identificador);
        System.out.println("Créditos disponibles: " + creditosDisponibles);
        System.out.println("Partidas jugadas: " + partidasJugadas);
    }


    public String getNombre() {
        return nombre;
    }

    public int getIdentificador() {
        return identificador;
    }

    public int getCreditosDisponibles() {
        return creditosDisponibles;
    }
}
