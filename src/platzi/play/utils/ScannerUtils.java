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
        int value = SCANNER.nextInt();
        SCANNER.nextLine();

        return value;
    }

    public static double inputDouble( String label ) {
        System.out.println( label + ": ");
        double value = SCANNER.nextDouble();
        SCANNER.nextLine();

        return value;
    }
}
