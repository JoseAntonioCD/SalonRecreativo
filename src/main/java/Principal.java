import model.MaquinaArcade;

import static utils.Utils.*;

public class Principal {
    public static void main(String[]args){
        int opcion = 0;

        do{
            System.out.println("|=================== MENU =====================|");
            System.out.println("|1. Registrar nuevo jugador                    |");
            System.out.println("|2. Registrar nueva máquina arcade             |");
            System.out.println("|3. Recargar créditos a un jugador             |");
            System.out.println("|4. Listar jugadores                           |");
            System.out.println("|5. Listar máquinas                            |");
            System.out.println("|6 Listar máquinas activas                     |");
            System.out.println("|7. Realizar el mantenimiento a una máquina    |");
            System.out.println("|8. Jugar una partida                          |");
            System.out.println("|9. Mostrar el jugador más activo              |");
            System.out.println("|10. Mostrar la máquina más usada              |");
            System.out.println("|11. Mostrar el ranking de una máquina concreta|");
            System.out.println("|0. Salir                                      |");
            System.out.println("|==============================================|");

            opcion = pideEnteroAcotado("Introduzca la opción deseada","Su opción no existe, " +
                    "por favor elija una opción válida",0,11);

            switch(opcion){
                case 1:

                    break;

                case 2:
                    crearMaquinaArcade();
            }
        }while(opcion != 0);
    }

    public static MaquinaArcade crearMaquinaArcade(){
        System.out.println("======REGISTRO MÁQUINA ARCADE======");

        String nombre =leerString("Introduzca el nombre de la máquina: ");

        String genero =leerString("Introduzca el género de la máquina: (Shooter, Plataforma, Puzzle, etc...");

        int precioPartida = leeEntero("Introduzca el precio por partida de la máquina: ","ERROR. VALOR NO VÁLIDO.");

        boolean activo = leerBoolean("Está la máquina activa? Y/N");

        MaquinaArcade nueva = new MaquinaArcade(nombre,genero,precioPartida,activo);

        System.out.println("Máquina registrada con éxito.");

        return nueva;
    }
}
