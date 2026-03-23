package platzi.play;

import platzi.play.contenido.Movie;
import platzi.play.plataforma.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Platzi Play!");

        // Creamos una película
        Movie movie = new Movie();      // Instanciar un objeto a partir de una clase

        // Agregamos valores a los atributos del objeto movie
        movie.title = "León: The Professional";
        movie.releaseDate = LocalDate.of(1994, 9, 14);
        movie.releaseLocation = "Francia";
        movie.genre = "Acción";
        movie.director = "Luc Besson";
        movie.duration = 110;           // 1h 50m
        movie.rating = 4.5;

        // Creamos un usuario
        User user = new User();
        user.name = "Juan C";
        user.email = "jcarlosj.dev@gmail.com";
        user.password = "123456789";
        user.createdAt = LocalDateTime.now();

        // Obtener información detallada del usuario
        System.out.println( user.getInfo() );

        // Obtenemos información sobre la película que ve el usuario
        user.watch( movie );

        // Obtener información de la ficha técnica de la película
        System.out.println( movie.getInfo() );
    }
}
