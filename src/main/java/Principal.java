import model.Jugador;
import model.MaquinaArcade;
import model.SalaRecreativa;

//import static model.Jugador.recargarCreditos;
import static model.SalaRecreativa.*;
import static utils.Utils.*;

public class Principal {
    public static void main(String[] args) {
        int opcion = 0;
        do {
            System.out.println("|====================== MENU ========================|" +
                    "\n|1. Registrar nuevo jugador                          |" +
                    "\n|2. Registrar nueva máquina arcade                   |" +
                    "\n|3. Recargar créditos a un jugador                   |" +
                    "\n|4. Listar jugadores                                 |" +
                    "\n|5. Listar máquinas                                  |" +
                    "\n|6 Listar máquinas activas                           |" +
                    "\n|7. Realizar el mantenimiento a una máquina          |" +
                    "\n|8. Jugar una partida                                |" +
                    "\n|9. Mostrar el jugador más activo                    |" +
                    "\n|10. Mostrar la máquina más usada                    |" +
                    "\n|11. Mostrar el ranking top 3 de una máquina concreta|" +
                    "\n|0. Salir                                            |" +
                    "\n|====================================================|");

            opcion = pideEnteroAcotado("Introduzca la opción deseada", "Su opción no existe, " +
                    "por favor elija una opción válida", 0, 11);

            switch (opcion) {
                case 1:
                    SalaRecreativa.registrarJugadorPorUsuario();
                    break;

                case 2:
                  SalaRecreativa.agregarMaquina(crearMaquinaArcade());
                    break;
                case 3:
                    Jugador jugador = SalaRecreativa.buscarJugadorPorId(); // Buscar la instancia
                    if (jugador != null) {
                        jugador.recargarCreditos(); // Llamar sobre la instancia concreta
                    }
                    break;

                case 4:
                    SalaRecreativa.listarJugadores();
                    break;
                case 5:
                    SalaRecreativa.listarMaquinas();
                    break;
                case 6:
                    SalaRecreativa.listarMaquinasActivas();
                    break;
                case 7:
                    SalaRecreativa.gestionarMantenimientoMaquina();
                    break;

                case 8:
                     SalaRecreativa.jugarPartidaMenu();
                    break;
                case 9:
                    SalaRecreativa.jugadorMasActivo();
                    break;
                case 10:
                    SalaRecreativa.maquinaMasUsada();
                    break;
                case 11:
                    mostrarRankingMaquinaMenu();
                    break;
            }
        } while (opcion != 0);
    }

    /**
     * Método que muestra el ranking top 3 mediante un menú en el que elijes la máquina en concreto
     */
    public static void mostrarRankingMaquinaMenu() {
        SalaRecreativa.listarMaquinas();
        int idMaquina = pideEnteroAcotado("Seleccione la máquina (1.." + SalaRecreativa.getMaquinas().length + "):", "Opción no válida", 1, SalaRecreativa.getMaquinas().length);
        MaquinaArcade maquina = SalaRecreativa.getMaquinas()[idMaquina - 1];
        maquina.mostrarRanking();
    }

}
