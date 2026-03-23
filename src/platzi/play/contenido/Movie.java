package platzi.play.contenido;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Movie {
    // Atributos
    public String title;
    public int year;
    public LocalDate releaseDate;
    public String releaseLocation;
    public String director;
    public String genre;
    public int duration;
    public double rating;
    public boolean isAvailable;

    // Métodos
    public void reproducir(){
        System.out.println( title + " se está reproduciendo... ");
    }

    public String getInfo() {
        return title +
                ", (" + releaseDate.getYear() + ") \n Director: " + director +
                "\n Género: " + genre +
                "\n Duración: " + duration +
                "\n Fecha de lanzamiento: " + releaseDate.toString() +
                "\n Lugar de lanzamiento: " + releaseLocation +
                "\n Disponible: " + isAvailable +
                "\n Calificación: " + rating + "/5.0 " +
                "\n " + ( isPopular() ? "Es popular" : "No es popular" ) ;
    }

    public void rate( double rating ) {
        if( rating >= 0 && rating <= 5 ) {
            this.rating = rating;
        }
    }

    public boolean isPopular(){
        return rating >= 4;
    }
}
