package platzi.play;

import platzi.play.contenido.Movie;
import platzi.play.plataforma.User;

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

        // Creamos un usuario
        User user = new User();
        user.name = "Juan C";
        user.email = "jcarlosj.dev@gmail.com";
        user.password = "123456789";

        // Obtenemos información sobre la película que ve el usuario
        user.watch( movie );
    }
}
