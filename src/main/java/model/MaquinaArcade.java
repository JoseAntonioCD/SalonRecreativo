package model;

import static utils.Utils.generarNumeroAleatorio;

public class MaquinaArcade {

    private String nombre;
    private String genero;
    private int precioPartida;
    private boolean activa = true;
    private int numeroPartidasJugadas = 0;

    private int[] rankingTop3 = new int[3];
    private String[] top3Jugadores = new String[3];

    public MaquinaArcade(String nombre, String genero, int precioPartida, boolean activo) {
        this.nombre = nombre;
        this.genero = genero;
        this.precioPartida = precioPartida;
        this.activa = activo;


        for (int i = 0; i < 3; i++) {
            rankingTop3[i] = 0;
            top3Jugadores[i] = "---";
        }
    }

    public boolean isActiva() {
        return activa;
    }

    public void activar() {
        activa = true;
    }

    public void desactivar() {
        activa = false;
    }

    public void consultarEstadoMaquina() {
        if (activa) {
            System.out.println("La máquina está activa y funcional");
        } else {
            System.out.println("La máquina está bajo mantenimiento");
        }
    }


    /**
     * Método que se encarga de checkear si una máquina está en mantenimiento y de generar una puntuación, teniendo
     * en cuenta una vez que llega a un múltiplo de 100 partidas para cambiar el estado de la máquina en cuestión a inactivo,
     * actualizando el ranking de la máquina en caso de que rompa el top 3 en la puntuación
     * @param jugador El jugador que usará la máquina para jugar
     * @return Nos devuelve la puntuación del jugador
     */
    public int jugarPartida(Jugador jugador) {
        if (!activa) {
            System.out.println("La máquina está en mantenimiento. No se puede jugar.");
            return -1;
        }else {

            int puntuacion = SalaRecreativa.generarPuntuacion();
            numeroPartidasJugadas++;


            if (numeroPartidasJugadas % 100 == 0) {
                activa = false;
                System.out.println("La máquina ha alcanzado 100 partidas y ahora está en mantenimiento.");
            }


            actualizarTopRanking(puntuacion, jugador.getNombre());

            System.out.println("Puntuación de " + jugador.getNombre() + ": " + puntuacion);
            return puntuacion;
        }
    }

    /**
     * Método que actualiza el top ranking en caso de que alguien entre dentro del rango, reemplazando de manera acorde
     * los jugadores necesarios para que tenga coherencia
     * @param puntuacion La puntuación que el jugador a conseguido
     * @param nombreJugador El nombre del jugador que obtuvo esa calificación
     */
    private  void actualizarTopRanking(int puntuacion, String nombreJugador) {
        if (puntuacion > rankingTop3[0]) {
            rankingTop3[2] = rankingTop3[1];
            rankingTop3[1] = rankingTop3[0];
            rankingTop3[0] = puntuacion;

            top3Jugadores[2] = top3Jugadores[1];
            top3Jugadores[1] = top3Jugadores[0];
            top3Jugadores[0] = nombreJugador;

        } else if (puntuacion > rankingTop3[1]) {
            rankingTop3[2] = rankingTop3[1];
            rankingTop3[1] = puntuacion;

            top3Jugadores[2] = top3Jugadores[1];
            top3Jugadores[1] = nombreJugador;

        } else if (puntuacion > rankingTop3[2]) {
            rankingTop3[2] = puntuacion;
            top3Jugadores[2] = nombreJugador;
        }
    }

    /**
     * Método que enseña el ranking top 3 de una máquina en concreto
     */
    public void mostrarRanking() {
        System.out.println("=== Ranking Top3 de la máquina: " + nombre + " ===");
        for(int i=0; i<3; i++) {
            System.out.println((i+1) + ". " + rankingTop3[i]);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getPrecioPartida() {
        return precioPartida;
    }

    public void setPrecioPartida(int precioPartida) {
        this.precioPartida = precioPartida;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public int getNumeroPartidasJugadas() {
        return numeroPartidasJugadas;
    }

    public void setNumeroPartidasJugadas(int numeroPartidasJugadas) {
        this.numeroPartidasJugadas = numeroPartidasJugadas;
    }

    public int[] getRankingTop3() {
        return rankingTop3;
    }

    public void setRankingTop3(int[] rankingTop3) {
        this.rankingTop3 = rankingTop3;
    }

    public String[] getTop3Jugadores() {
        return top3Jugadores;
    }

    public void setTop3Jugadores(String[] top3Jugadores) {
        this.top3Jugadores = top3Jugadores;
    }
}
