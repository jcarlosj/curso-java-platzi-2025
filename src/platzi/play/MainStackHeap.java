package platzi.play;

import platzi.play.contenido.Movie;

public class MainStackHeap {
    public static void main(String[] args) {
        Movie lionKing = new Movie( "El Rey Leon", 135, "Animada" );
        Movie harryPotter = new Movie( "Harry Potter", 200, "Fantasia" );

        System.out.println( lionKing + " -> " + lionKing.title );
        System.out.println( harryPotter + " -> " + harryPotter.title );

        lionKing = harryPotter;             // lionKing apunte a donde se encuentra harryPotter en la memoria HEAP, en este momento los valores de harryPotter ya no son accesibles, va a ser eliminado por el Garbage Collector
        lionKing.title = "El Hobbit";       // Le cambiamos el valor del titulo

        // Como ambas estan apuntando a la misma, las dos muestran el mismo valor
        System.out.println( lionKing + " -> " + lionKing.title );
        System.out.println( harryPotter + " -> " + harryPotter.title );
    }
}
