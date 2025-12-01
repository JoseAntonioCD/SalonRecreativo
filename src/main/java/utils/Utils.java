package utils;

public class Utils {
    public static void leeEntero(String msj){
        System.out.println("Introduzc un número entero a continuación: ");

    }

    public static boolean comprobarRango(int valor, int min, int max){
        boolean valorValido = true;

        System.out.println("Por favor introduzca un valor para comprobar si el valor es válido: ");

        return valorValido;
    }

    public static int  generarNumeroAleatorio(int min, int max){
        return (int)(Math.random()*(max-min+1)+min);
    }
}
