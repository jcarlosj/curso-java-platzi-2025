package platzi.play;

import platzi.play.contenido.Movie;

public class Main {
    public static void main(String[] args) {
        System.out.println("Platzi Play!");

        // Creamos una película
        Movie movie = new Movie();      // Instanciar un objeto a partir de una clase

        // Agregamos valores a los atributos del objeto movie
        movie.title = "León: The Professional";
        movie.year = 1994;
        movie.genre = "Acción";
        movie.director = "Luc Besson";
        movie.duration = 110;           // 1h 50m
        movie.rating = 4.5;

        // Obtenemos información detallada de la película
        System.out.println( movie.getInfo() );
    }
}
