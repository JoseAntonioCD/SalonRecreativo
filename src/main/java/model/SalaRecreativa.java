package model;

import static utils.Utils.*;

public class SalaRecreativa {

    private static Jugador[] jugadores = null;
    private static MaquinaArcade[] maquinas = null;


    public static void agregarJugador(Jugador nuevo) {
        if (jugadores == null) {
            jugadores = new Jugador[1];
            jugadores[0] = nuevo;
        } else {
            Jugador[] temp = new Jugador[jugadores.length + 1];
            for (int i = 0; i < jugadores.length; i++) {
                temp[i] = jugadores[i];  // CORREGIDO
            }
            temp[jugadores.length] = nuevo;
            jugadores = temp;
        }
    }

    public static void registrarJugadorPorUsuario() {
        String nombre = leerString("Introduce el nombre del jugador:");
        int id = generarNumeroAleatorio(1, 99999);

        Jugador j = new Jugador(nombre, id);
        agregarJugador(j);

        System.out.println("Jugador agregado correctamente: " + nombre);
    }

    public static void listarJugadores() {
        if (jugadores == null) {
            System.out.println("No hay jugadores registrados.");
            return;
        }

        System.out.println("=== Jugadores registrados ===");
        for (Jugador j : jugadores) {
            System.out.println(j.getNombre() + " (ID: " + j.getIdentificador() + ")");
        }
    }

    public static Jugador buscarJugadorPorId() {
        int id = pideEnteroAcotado("Introduzca ID a buscar", "ID incorrecto", 0, 99999);

        if (jugadores == null || jugadores.length == 0) {
            System.out.println("No hay jugadores registrados.");
            return null;
        }

        for (Jugador j : jugadores) {
            if (j.getIdentificador() == id) {
                // Retornamos directamente el jugador encontrado
                return j;
            }
        }

        System.out.println("Jugador no encontrado.");
        return null;
    }



    public static void agregarMaquina(MaquinaArcade nueva) {
        if (maquinas == null) {
            maquinas = new MaquinaArcade[1];
            maquinas[0] = nueva;
        } else {
            MaquinaArcade[] temp = new MaquinaArcade[maquinas.length + 1];
            for (int i = 0; i < maquinas.length; i++) {
                temp[i] = maquinas[i];
            }
            temp[maquinas.length] = nueva;
            maquinas = temp;
        }
    }
    public static MaquinaArcade crearMaquinaArcade() {
        String nombre = leerString("Introduce el nombre de la máquina:");
        String genero = leerString("Introduce el género de la máquina:");
        int precio = pideEnteroAcotado("Introduce el precio de partida:", "Debe ser un número positivo", 1, 10000);

        return new MaquinaArcade(nombre, genero, precio, true);
    }
    public static void listarMaquinas() {
        if (maquinas == null) {
            System.out.println("No hay máquinas registradas.");
            return;
        }

        System.out.println("=== Máquinas disponibles ===");
        for (MaquinaArcade m : maquinas) {
            System.out.println(m.getNombre());
        }
    }

    public static void listarMaquinasActivas() {
        if (maquinas == null) {
            System.out.println("No hay máquinas registradas.");
            return;
        }

        System.out.println("=== Máquinas activas ===");
        for (MaquinaArcade m : maquinas) {
            if (m.isActiva()) {
                System.out.println(m.getNombre());
            }
        }
    }


    public static boolean gestionarPartida(Jugador jugador, MaquinaArcade maquina) {


        if (!maquina.isActiva()) {
            System.out.println("=== LA MÁQUINA ESTÁ EN MANTENIMIENTO ===");
            return false;
        }


        if (!jugador.comprobacionCreditos(maquina.getPrecioPartida())) {
            System.out.println("=== CRÉDITOS INSUFICIENTES ===");
            return false;
        }


        jugador.gastarCreditos(maquina.getPrecioPartida());


        int puntuacion = maquina.jugarPartida();
        jugador.incrementarPartidasJugadas();


        System.out.println("Puntuación obtenida por " + jugador.getNombre() + ": " + puntuacion);

        return true;
    }
}

