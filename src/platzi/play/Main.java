package platzi.play;

import platzi.play.contenido.Movie;
import platzi.play.plataforma.User;
import platzi.play.utils.ScannerUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    // Define una constante: El valor nunca cambia, se comparte con todas las instancias
    public static final String VERSION = "1.0.0";
    public static final String APP_NAME = "Platzi Play!";

    public static void main(String[] args) {
        System.out.println( APP_NAME + " v" + VERSION );

        // Creamos una película
        Movie movie = new Movie();      // Instanciar un objeto a partir de una clase

        // Agregamos valores a los atributos del objeto movie
        movie.title = ScannerUtils.inputText("Nombre película" );                   // "León: The Professional"
        movie.releaseDate = LocalDate.of(1994, 9, 14);
        movie.releaseLocation = ScannerUtils.inputText("Lugar de estreno");         // "Francia"
        movie.genre = ScannerUtils.inputText( "Genero de la película" );            // "Acción"
        movie.director = ScannerUtils.inputText( "Nombre del director" );           // "Luc Besson"
        movie.duration = ScannerUtils.inputInt( "Duración de la película" );        // 110, 1h 50m
        movie.rating = ScannerUtils.inputDouble( "Calificación de la película" );   // 4.5;

        // Casting de datos
        long durationLong = movie.duration;                     // Casting implícito: Ambos son de tipo int, y permite el casting implícito, básicamente por que long es un tipo de dato mas grande que int
        int rating = (int) movie.rating;                        // Casting explícito: Convertir un tipo int grande a uno más pequeño, en este caso con la perdida de decimales
        long prizes = Long.parseLong( "25" );                // Casting explícito: Usando una clase, para convertir un String en un Long
        int number = (int) Double.parseDouble( "3.1415" );   // Casting explícito: Usando una clase, para convertir un String en un Double

        System.out.println(
                "Casting de tipos" +
                "\n >> durationLong: " + durationLong +
                "\n >> rating: " + rating +
                "\n >> prizes: " + prizes +
                "\n >> number: " + number
        );

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
