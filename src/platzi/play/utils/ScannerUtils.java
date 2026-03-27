package platzi.play.utils;

import java.util.Scanner;

public class ScannerUtils {
    // Atributos estáticos y constante
    public static final Scanner SCANNER = new Scanner(System.in);

    // Métodos estáticos
    public static String inputText( String label ) {
        System.out.println( label + ": ");
        return SCANNER.nextLine();
    }

    public static int inputInt( String label ) {
        System.out.println( label + ": ");

        // Validamos si el valor no es un Entero
        while( !SCANNER.hasNextInt() ) {
            System.out.println( "Valor invalido, debe ingresar numero entero para continuar" );
            SCANNER.next();         // Descargamos la entrada de datos, vamos a la siguiente entrada
        }

        int value = SCANNER.nextInt();
        SCANNER.nextLine();

        return value;
    }

    public static double inputDouble( String label ) {
        System.out.println( label + ": ");

        // Validamos si el valor no es un Entero
        while( !SCANNER.hasNextDouble() ) {
            System.out.println( "Valor invalido, debe ingresar numero decimal para continuar" );
            SCANNER.next();         // Descargamos la entrada de datos, vamos a la siguiente entrada
        }

        double value = SCANNER.nextDouble();
        SCANNER.nextLine();

        return value;
    }
}
