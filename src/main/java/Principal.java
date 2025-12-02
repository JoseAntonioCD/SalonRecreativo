import static utils.Utils.pideEnteroAcotado;

public class Principal {
    public static void main(String[]args){
        int opcion = 0;

        do{
            System.out.println("\n|=================== MENU =====================|");
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

        }while(opcion != 0);
    }
}
