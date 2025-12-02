package utils;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Utils {
    /**
     * Método que lee un número y se asegura de que sea entero, indicando mediante un mensaje si el usuario se ha equivocado al introducir un número que no sea entero.
     * @param mensaje Mensaje que dará contexto sobre el número deseado
     * @param mensajeError Mensaje que aparecerá en caso de que el número introducido sea erroneo
     * @return Número entero que ha superado el try-catch
     */
    public static int leeEntero( String mensaje, String mensajeError){
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        boolean noHayError = true;
        do {
            System.out.println(mensaje);
            try {
                numero = sc.nextInt();
                noHayError = true;
            } catch (InputMismatchException e) {
                System.out.println(mensajeError);
                noHayError = false;
                sc.nextLine(); // Limpiar buffer
            }
        } while (!noHayError);
        return numero;
    }

    /**
     *Método que se usa para comprobar si un valor entero está dentro del rango especificado
     * @param valor Valor introducido a determinar si está en el rango
     * @param min Valor mínimo a comparar
     * @param max Valor máximo a comparar
     * @return Indica si el valor está dentro del rango establecio o no.
     */
    public static boolean comprobarRango(int valor, int min, int max){
        boolean valorValido = false;
        do {
            System.out.println("Por favor introduzca un valor para comprobar si el valor es válido: ");
            if (valor >= min && valor <= max) {
                System.out.println("El valor introducido está dentro del rango válido");
                valorValido = true;
            } else {
                System.out.println("El valor introducido está fuera del rango válido, inténtelo otra vez.");
            }
        }while (valor < min || valor > max) ;
        return valorValido;
    }

    /**
     * Método que genera un número aleatorio entre los valores máximos y mínimos
     * @param min Valor mínimo
     * @param max Valor máximo
     * @return Valor generado aletoriamente entre los máximos y mínimos
     */
    public static int  generarNumeroAleatorio(int min, int max){
        return (int)(Math.random()*(max-min+1)+min);
    }

    public static int pideEnteroAcotado(String mensaje, String mensajeError, int min, int max) {
        int numero;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(mensaje);
            numero = sc.nextInt();
            if (numero < min || numero > max) {
                System.out.println(mensajeError);
            }
        } while (numero < min || numero > max);
        return numero;
    }

    public static void imprimeArray(int[] array) {
        System.out.println("Elementos del array:");
        for (int i = 0; i < array.length; i++) {
            System.out.println("[" + i + "] = " + array[i]);
        }
    }
}
