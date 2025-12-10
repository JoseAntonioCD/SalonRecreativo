package model;

import static utils.Utils.*;

public class SalaRecreativa {

    private static Jugador[] jugadores = null;
    private static MaquinaArcade[] maquinas = null;

    /**
     * Método para agregar un nuevo jugador al array de jugadores el cuál busca el array y dependiendo de lo que encuentre
     * creará jugador nuevo o buscará el array para un puesto vacío en el que insertar dicho jugador
     * @param nuevo Se trata del jugador nuevo que será añadido al array
     */
    public static void agregarJugador(Jugador nuevo) {
        if (jugadores == null) {
            jugadores = new Jugador[1];
            jugadores[0] = nuevo;
        } else {
            Jugador[] temp = new Jugador[jugadores.length + 1];
            for (int i = 0; i < jugadores.length; i++) {
                temp[i] = jugadores[i];
            }
            temp[jugadores.length] = nuevo;
            jugadores = temp;
        }
    }

    /**
     * Método que permite crear un usuario nuevo manualmente usando la terminal, introduciendo el nombre y generando
     * un id aleatorio con el cuál será identificado.
     */
    public static void registrarJugadorPorUsuario() {
        String nombre = leerString("Introduce el nombre del jugador:");
        int id = generarNumeroAleatorio(1, 99999);

        Jugador j = new Jugador(nombre, id);
        agregarJugador(j);

        System.out.println("Jugador agregado correctamente: " + nombre);
    }

    /**
     * Método que nos enseña todos los jugadores registrados, enseñándonos su nombre y su id
     */
    public static void listarJugadores() {
        if (jugadores == null || jugadores.length == 0) {
            System.out.println("No hay jugadores registrados.");
            return;
        }

        System.out.println("=== Jugadores registrados ===");
        for (Jugador j : jugadores) {
            System.out.println(j.getNombre() + " (ID: " + j.getIdentificador() + ")");
        }
    }

    /**
     * Método que nos permite usar el id de un jugador para llamarlo desde la lista del array
     * @return Jugador específico buscado por el id
     */
    public static Jugador buscarJugadorPorId() {
        if (jugadores == null || jugadores.length == 0) {
            System.out.println("No hay jugadores registrados.");
            return null;
        }
        listarJugadores();

        int id = pideEnteroAcotado("Introduce el ID del jugador:", "ID incorrecto", 0, 99999);

        for (Jugador j : jugadores) {
            if (j.getIdentificador() == id) {
                return j;
            }
        }

        System.out.println("Jugador no encontrado.");
        return null;
    }

    /**
     * Método que nos localiza el jugador con más partidas jugadas a lo largo del array de jugadores
     * @return Jugador más activo de todos
     */
    public static Jugador jugadorMasActivo() {
        if (jugadores == null || jugadores.length == 0) return null;

        Jugador activo = jugadores[0];
        for (Jugador j : jugadores) {
            if (j.getPartidasJugadas() > activo.getPartidasJugadas()) {
                activo = j;
            }
        }

        System.out.println("Jugador más activo: " + activo.getNombre() + " con " + activo.getPartidasJugadas() + " partidas.");
        return activo;
    }


    public static MaquinaArcade[] getMaquinas() {
        return maquinas;
    }

    /**
     * Método con el que se agrega una máquina recién creada al array de las máquinas
     * @param nueva Nueva máquina creada que será integrada al array
     */
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

    /**
     * Método con el que creamos una nueva máquina arcade para la SalaRecreativa
     * @return Máquina recién creada
     */
    public static MaquinaArcade crearMaquinaArcade() {
        String nombre = leerString("Introduce el nombre de la máquina:");
        String genero = leerString("Introduce el género de la máquina:");
        int precio = pideEnteroAcotado("Introduce el precio de partida:", "Debe ser un número positivo", 1, 10000);

        return new MaquinaArcade(nombre, genero, precio, true);
    }

    /**
     * Método que lista todas las máquinas existentes, estén o no en mantenimiento
     */
    public static void listarMaquinas() {
        if (maquinas == null || maquinas.length == 0) {
            System.out.println("No hay máquinas registradas.");
            return;
        }

        System.out.println("=== Máquinas disponibles ===");
        for (int i = 0; i < maquinas.length; i++) {
            System.out.println((i + 1) + ". " + maquinas[i].getNombre() + (maquinas[i].isActiva() ? " (Activa)" : " (Mantenimiento)"));
        }
    }

    /**
     * Método que enseña una lista con las máquinas existentes que están activas y no en mantenimiento
     */
    public static void listarMaquinasActivas() {
        if (maquinas == null || maquinas.length == 0) {
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

    /**
     * Método que nos devuelve la máquina con el mayor número de partidas jugadas dentro del array
     * @return Máquina más usada
     */
    public static MaquinaArcade maquinaMasUsada() {
        if (maquinas == null || maquinas.length == 0) return null;

        MaquinaArcade usada = maquinas[0];
        for (MaquinaArcade m : maquinas) {
            if (m.getNumeroPartidasJugadas() > usada.getNumeroPartidasJugadas()) {
                usada = m;
            }
        }

        System.out.println("Máquina más usada: " + usada.getNombre() + " con " + usada.getNumeroPartidasJugadas() + " partidas.");
        return usada;
    }

    /**
     * Menú que permite gestionar el estado de una máquina manualmente, decidiendo ponerla en modo activo o inactivo a voluntad
     */
    public static void gestionarMantenimientoMaquina() {
        listarMaquinas();
        int id = pideEnteroAcotado("Seleccione la máquina (1.." + maquinas.length + "):", "Opción no válida", 1, maquinas.length);

        MaquinaArcade m = maquinas[id - 1];
        int opcion = pideEnteroAcotado("1.Activar máquina  2.Desactivar máquina", "Opción no válida", 1, 2);

        if (opcion == 1) m.activar();
        else m.desactivar();

        System.out.println("Estado actualizado de la máquina: " + m.getNombre());
    }

    /**
     * Menú básico que te permite elegir las máquinas disponibles para realizar la partida mediante la inserción de un entero
     */
    public static void jugarPartidaMenu() {
        Jugador jugador = buscarJugadorPorId();
        if (jugador == null) return;

        listarMaquinas();
        int idMaquina = pideEnteroAcotado("Seleccione la máquina (1.." + getMaquinas().length + "):", "Opción no válida", 1, getMaquinas().length);
        MaquinaArcade maquina = getMaquinas()[idMaquina - 1];

        gestionarPartida(jugador, maquina);
    }

    /**
     * Método que gestiona el transcurso de una partida, comprobando si la máquina está activa, si el jugador tiene suficientes créditos
     * y cuando se cumplan esas condiciones, se restarán los créditos del jugador y se generará la puntuación del usuario
     * @param jugador Jugador que realizará la partida
     * @param maquina Maquina en la que se ha jugado la partida
     */
    public static void gestionarPartida(Jugador jugador, MaquinaArcade maquina) {
        if (jugador == null) {
            System.out.println("Jugador no válido.");
            return;
        }

        if (!maquina.isActiva()) {
            System.out.println("=== MÁQUINA EN MANTENIMIENTO ===");
            return;
        }

        if (!jugador.comprobacionCreditos(maquina.getPrecioPartida())) {
            System.out.println("=== CRÉDITOS INSUFICIENTES ===");
            return;
        }

        jugador.gastarCreditos(maquina.getPrecioPartida());

        int puntuacion = maquina.jugarPartida(jugador);

        jugador.incrementarPartidasJugadas();

        System.out.println("Partida completada. Puntuación obtenida: " + puntuacion);
    }

    /**
     * Método que genera una puntuación aleatoria de 0 a 9999
     * @return Número aleatorio
     */
    public static int generarPuntuacion() {
        return (int) (Math.random() * 10000);
    }
}

