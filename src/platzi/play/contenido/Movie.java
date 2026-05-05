package platzi.play.contenido;

import java.time.LocalDate;

public class Movie {
    // Atributos
    private String title;
    private int year;
    private LocalDate releaseDate;
    private String releaseLocation;
    private String director;
    private Genre genre;
    private int duration;
    private double rating;
    private boolean isAvailable;

    // Constructor
    public Movie (
            String title,
            int duration,
            Genre genre
    ) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.releaseDate = LocalDate.now();
        this.isAvailable = true;
    }

    public Movie(
            String title,
            int duration,
            Genre genre,
            double rating
    ) {
        this( title, duration, genre ); // Invocar el constructor que espere esos parámetros, en su respectivo orden y tipo
        this.rate( rating );            // Invocar a métodos de la clase
    }

    // Métodos
    public void reproducir() {
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

    // Getters
    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getReleaseLocation() {
        return releaseLocation;
    }

    public String getDirector() {
        return director;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public double getRating() {
        return rating;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setReleaseLocation(String releaseLocation) {
        this.releaseLocation = releaseLocation;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setRating(double rating) {
        this.rate(rating);
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

}
