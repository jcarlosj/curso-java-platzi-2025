package platzi.play;

import platzi.play.contenido.Genre;
import platzi.play.contenido.Movie;

public class MainStackHeap {
    public static void main(String[] args) {
        Movie lionKing = new Movie( "El Rey Leon", 135, Genre.ANIMATED );
        Movie harryPotter = new Movie( "Harry Potter", 200, Genre.FANTASY );

        System.out.println( lionKing + " -> " + lionKing.getTitle() );
        System.out.println( harryPotter + " -> " + harryPotter.getTitle() );

        lionKing = harryPotter;             // lionKing apunte a donde se encuentra harryPotter en la memoria HEAP, en este momento los valores de harryPotter ya no son accesibles, va a ser eliminado por el Garbage Collector
        lionKing.setTitle( "El Hobbit" );   // Le cambiamos el valor del título

        // Como ambas estan apuntando a la misma, las dos muestran el mismo valor
        System.out.println( lionKing + " -> " + lionKing.getTitle() );
        System.out.println( harryPotter + " -> " + harryPotter.getTitle() );
    }
}
