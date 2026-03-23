package platzi.play;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Platzi Play!");

        // Observando por las entradas en la consola
        Scanner scan = new Scanner(System.in);

        // Capturamos la siguiente línea en la consola
        System.out.println("¿Cuál es tú nombre? ");
        String name = scan.nextLine();

        // Capturamos la siguiente línea en la consola
        System.out.println("¿Cuál es tu edad? ");
        int edad = scan.nextInt();

        System.out.println("Bienvenido " + name + " a Platzi Play! \nPuedes ver contenido +" + edad);
    }
}
