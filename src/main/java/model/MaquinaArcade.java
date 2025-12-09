package model;

import static utils.Utils.generarNumeroAleatorio;

public class MaquinaArcade {

    private String nombre;
    private String genero;
    private int precioPartida;
    private boolean activa = true;
    private int partidasJugadas = 0;

    private int[] rankingTop3 = new int[3];

    public MaquinaArcade(String nombre, String genero, int precioPartida, boolean activo) {
        this.nombre = nombre;
        this.genero = genero;
        this.precioPartida = precioPartida;
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


    public int jugarPartida() {
        if (!activa) {
            System.out.println("La máquina está desactivada por mantenimiento.");
            return -1;
        }

        int puntuacion = generarNumeroAleatorio(0, 9999);
        partidasJugadas++;

        if (partidasJugadas % 100 == 0) {
            activa = false;
        }

        actualizarRanking(puntuacion);
        return puntuacion;
    }

    private void actualizarRanking(int puntuacion) {
        if (puntuacion > rankingTop3[0]) {
            rankingTop3[2] = rankingTop3[1];
            rankingTop3[1] = rankingTop3[0];
            rankingTop3[0] = puntuacion;
        } else if (puntuacion > rankingTop3[1]) {
            rankingTop3[2] = rankingTop3[1];
            rankingTop3[1] = puntuacion;
        } else if (puntuacion > rankingTop3[2]) {
            rankingTop3[2] = puntuacion;
        }
    }


    public String getNombre() {
        return nombre;
    }

    public int getPrecioPartida() {
        return precioPartida;
    }
}
