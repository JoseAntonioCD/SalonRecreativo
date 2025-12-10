package model;

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


    /**
     * Método que permite añadir una cantidad X de créditos al jugador en concreto
     */
    public void recargarCreditos() {
        int creditosARecargar = utils.Utils.leeEntero(
                "Introduzca la cantidad de créditos a recargar:",
                "Valor incorrecto"
        );
        creditosDisponibles += creditosARecargar;
        System.out.println("Créditos actuales de " + nombre + ": " + creditosDisponibles);
    }

    /**
     * Método que comprueba si un usuario tiene suficientes créditos como para jugar a una máquina
     * @param precioPartida Precio de la partida, como es especificado en la máquina
     * @return Si el jugador tiene suficientes créditos como para jugar o no
     */
    public boolean comprobacionCreditos(int precioPartida) {
        return creditosDisponibles >= precioPartida;
    }

    /**
     * Método que resta los créditos necesarios para jugar una partida de los créditos disponibles del jugador
     * @param precioPartida El precio de la partida, tal y como está especificado en la máuqina
     */
    public void gastarCreditos(int precioPartida) {
        creditosDisponibles -= precioPartida;
    }

    /**
     * Método que incrementa el contador de partidas jugadas de un jugador al realizar una partida
     */
    public void incrementarPartidasJugadas() {
        partidasJugadas++;
    }

    /**
     * Método que enseña toda la información de un usuario
     */
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

    public int getPartidasJugadas(){
        return partidasJugadas;
    }
}
