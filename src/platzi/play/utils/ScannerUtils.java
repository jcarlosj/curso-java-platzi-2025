package platzi.play.utils;

import java.util.Scanner;

public class ScannerUtils {
    // Atributos estáticos
    public static Scanner scanner = new Scanner(System.in);

    // Métodos estáticos
    public static String inputText( String label ) {
        System.out.println( label + ": ");
        return scanner.nextLine();
    }

    public static int inputInt( String label ) {
        System.out.println( label + ": ");
        int value = scanner.nextInt();
        scanner.nextLine();

        return value;
    }

    public static double inputDouble( String label ) {
        System.out.println( label + ": ");
        double value = scanner.nextDouble();
        scanner.nextLine();

        return value;
    }
}
