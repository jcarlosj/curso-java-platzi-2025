package platzi.play.plataforma;

import platzi.play.contenido.Movie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Platform {
    // Atributos
    private String name;
    private List<Movie> content;

    public Platform( String name ) {
        this.name = name;
        this.content = new ArrayList<>();
    }

    public void add( Movie movie ) {
        content.add(movie);
    }

    public List<String> getTitles() {
        System.out.println( "Listado títulos" );
        /*for (int i = 0; i < content.size(); i++) {
            System.out.println( i + 1 +". " + content.get( i ).getTitle() );
        }*/

        // Programación Funcional
        return content.stream()
                .map( Movie::getTitle )     // Transforma: movie -> movie.getTitle() --> Lambda la reemplazamos por un método de referencia Movie::getTitle, internamente hace lo mismo que la lambda. El metodo de referencia es un metodo que podemos llamar directamente desde la clase.
                .toList();
    }

    public void delete( Movie movie ) {
        this.content.remove( movie );
    }

    // Getters
    public String getName() {
        return name;
    }

    public List<Movie> getContent() {
        return content;
    }

    public Movie searchByTitle( String term ) {
        /*for ( Movie movie : content ) {
            if ( movie.getTitle().equalsIgnoreCase( term ) ) {
                return movie;
            }
        }*/
        // stream: Permite realizar acciones (filtros, condiciones, etc), sobre los elementos de una lista de forma fluida, ordenada y moderna
        return content.stream()                                                         // Crea el Stream a partir de un List
                .filter( movie -> movie.getTitle().equalsIgnoreCase( term ) )     // Itera y aplica un filtro
                .findFirst()                                                            // Toma solo el primer valor que entrega el filtro
                .orElse( null );                                                  // Si no encuentra nada retorna null

        // return null;
    }

    public List<Movie> searchByGenre( String genre ) {
        return content.stream()                                                           // Crea el Stream a partir de un List
                .filter( movie -> movie.getGenre().equalsIgnoreCase( genre ) )      // Itera y aplica un filtro
                .toList();                                                                 // Convierte los resultados del filtro como una lista
    }

    public int getTotalDuration() {
        return content.stream()
                .mapToInt( Movie::getDuration )     // Transforma un entero
                .sum();                             // Suma todos los enteros
    }

    public List<Movie> getPopularMovies() {
        return content.stream()
                .sorted( Comparator.comparingDouble( Movie::getRating ).reversed() )
                .toList();
    }

    public List<Movie> getPopularMovies( int quantity ) {
        return content.stream()
                .sorted( Comparator.comparingDouble( Movie::getRating ).reversed() )
                .limit( quantity )
                .toList();
    }

    public Movie  getLongerMovie() {
        return content.stream()
                .max( Comparator.comparingDouble( Movie::getDuration ) )
                .orElse( null );
    }

    public Movie getShorterMovie() {
        return content.stream()
                .min( Comparator.comparingDouble( Movie::getDuration ) )
                .orElse( null );
    }

    public List<Movie> getTheBestMovies() {
        return content.stream()
                .filter( movie -> movie.getRating() >= 4.5 )
                .toList();
    }
}
