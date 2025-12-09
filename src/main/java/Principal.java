import model.MaquinaArcade;
import model.SalaRecreativa;

import static model.Jugador.recargarCreditos;
import static model.SalaRecreativa.*;
import static utils.Utils.*;

public class Principal {
    public static void main(String[] args) {
        int opcion = 0;
        do {
            System.out.println("|=================== MENU =====================|" +
                    "\n|1. Registrar nuevo jugador                    |" +
                    "\n|2. Registrar nueva máquina arcade             |" +
                    "\n|3. Recargar créditos a un jugador             |" +
                    "\n|4. Listar jugadores                           |" +
                    "\n|5. Listar máquinas                            |" +
                    "\n|6 Listar máquinas activas                     |" +
                    "\n|7. Realizar el mantenimiento a una máquina    |" +
                    "\n|8. Jugar una partida                          |" +
                    "\n|9. Mostrar el jugador más activo              |" +
                    "\n|10. Mostrar la máquina más usada              |" +
                    "\n|11. Mostrar el ranking de una máquina concreta|" +
                    "\n|0. Salir                                      |" +
                    "\n|==============================================|");

            opcion = pideEnteroAcotado("Introduzca la opción deseada", "Su opción no existe, " +
                    "por favor elija una opción válida", 0, 11);

            switch (opcion) {
                case 1:

                    break;

                case 2:
                    crearMaquinaArcade();

                case 3:
                    recargarCreditos();

                case 4:
                    listarJugadores();

                case 5:
                    listarMaquinas();

                case 6:

                case 7:

                case 8:
                    gestionarPartida();

                case 9:

                case 10:

                case 11:

            }
        } while (opcion != 0);
    }

    public static MaquinaArcade crearMaquinaArcade() {
        System.out.println("======REGISTRO MÁQUINA ARCADE======");

        String nombre = leerString("Introduzca el nombre de la máquina: ");

        String genero = leerString("Introduzca el género de la máquina: (Shooter, Plataforma, Puzzle, etc...");

        int precioPartida = leeEntero("Introduzca el precio por partida de la máquina: ", "ERROR. VALOR NO VÁLIDO.");

        boolean activo = leerBoolean("Está la máquina activa? Y/N");

        MaquinaArcade nueva = new MaquinaArcade(nombre, genero, precioPartida, activo);

        System.out.println("Máquina registrada con éxito.");

        return nueva;
    }
}
