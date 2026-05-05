package platzi.play.utils;

import platzi.play.contenido.Genre;

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
    //
    public static Genre inputGenre(String label ) {
        while( true ) {
            System.out.println( label + ", opciones: ");

            for( Genre genre : Genre.values() ) {
                System.out.println( " - " + genre.name() );
            }

            System.out.println( "¿Cuál deseas? " );
            String input = SCANNER.nextLine();

            try {
                // .valueOf: Convierte un String en un tipo Genre
                return Genre.valueOf(input.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println( "Genero " + input + " desconocido. Intente de nuevo. " );
            }
        }
    }
}
