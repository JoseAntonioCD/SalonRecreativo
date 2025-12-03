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

    public int jugarPartida() {
        int puntuacion;
        if (!activo) {
            System.out.println("La máquina está desactivada por mantenimiento.");
            return -1;
        } else {
            puntuacion = generarNumeroAleatorio(0, 9999);
            partidasJugadas++;

            if (partidasJugadas % 100 == 0) {
                //activo == false;
            }

            actualizarRanking(puntuacion);
        }
        return puntuacion;
    }
    private void actualizarRanking(int puntuacion){
        if(puntuacion >rankingTop3[0]){
            rankingTop3[2] = rankingTop3[1];
            rankingTop3[1] = rankingTop3[0];
            rankingTop3[0] = puntuacion;
        }else if(puntuacion > rankingTop3[1]){
            rankingTop3[2] = rankingTop3[1];
            rankingTop3[1] = puntuacion;
        }else if(puntuacion>rankingTop3[2]){
            rankingTop3[2] = puntuacion;
        }
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        MaquinaArcade.nombre = nombre;
    }

    public static String getGenero() {
        return genero;
    }

    public static void setGenero(String genero) {
        MaquinaArcade.genero = genero;
    }

    public static int getPrecioPartida() {
        return precioPartida;
    }

    public static void setPrecioPartida(int precioPartida) {
        MaquinaArcade.precioPartida = precioPartida;
    }

    public MaquinaArcade(String nombre, String genero, int precioPartida, boolean activo){
        this.nombre = nombre;
        this.genero = genero;
        this.precioPartida = precioPartida;
        this.activo = activo;
    }
}
