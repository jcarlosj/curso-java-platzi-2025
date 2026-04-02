package platzi.play;

import platzi.play.contenido.Movie;
import platzi.play.plataforma.Platform;
import platzi.play.utils.ScannerUtils;

import java.util.List;

public class Main {
    // Define una constante: El valor nunca cambia, se comparte con todas las instancias
    public static final String VERSION = "1.0.0";
    public static final String APP_NAME = "Platzi Play!";

    public static final int ADD = 1;
    public static final int SHOW = 2;
    public static final int SEARCH_BY_TITLE = 3;
    public static final int SEARCH_BY_GENRE = 4;
    public static final int REMOVE = 5;
    public static final int EXIT = 6;

    public static void main(String[] args) {
        System.out.println( APP_NAME + " v" + VERSION );

        // Creamos una nueva Plataforma
        Platform platform = new Platform( APP_NAME );

        // Cargar películas
        addMovies( platform );

        // Menu interactivo usando un while
        while( true ) {
            int option = ScannerUtils.inputInt("""
                    Menu de navegación:
                    1. Agregar contenido
                    2. Mostrar todo
                    3. Buscar por titulo
                    4. Buscar por genero
                    5. Eliminar contenido
                    6. Salir
                    Ingresa una de las opciones:
                    """);
            System.out.println("Opcion elegida: " + option);

            // Usando switch
            switch( option ) {
                case ADD -> {
                    // Capturamos los valores que deseamos asignar a la creación de la película
                    String title = ScannerUtils.inputText( "Nombre película" );
                    String genre = ScannerUtils.inputText( "Genero de la película" );
                    int duration = ScannerUtils.inputInt( "Duración de la película" );
                    double rating = ScannerUtils.inputDouble( "Calificación de la película" );

                    // Creamos una película
                    Movie movie = new Movie( title, duration, genre, rating );      // Instanciar un objeto a partir de una clase

                    // Creamos una segunda película con valores predeterminados
                    Movie f1 = new Movie( "F1: The movie", 120, "Action" );

                    // Agregar la película a la lista de plataforma
                    platform.add( movie );
                    platform.add( f1 );

                    break;
                }
                case SHOW -> {
                    platform.showTitles();
                    break;
                }
                case SEARCH_BY_TITLE -> {
                    String term = ScannerUtils.inputText( "Buscar por titulo: " );
                    Movie movie = platform.searchByTitle( term );

                    System.out.println( "*** Resultados de búsqueda por titulo ***" );

                    if( movie != null ) {
                        System.out.println( movie.getInfo() );
                    }
                    else {
                        System.out.println( term + " no existe en " + APP_NAME );
                    }

                    break;
                }
                case SEARCH_BY_GENRE -> {
                    String term = ScannerUtils.inputText( "Buscar por genero: " );

                    System.out.println( "*** Resultados de búsqueda por genero ***" );

                    List<Movie> movies = platform.searchByGenre( term );
                    System.out.println( "Se han encontrado " + movies.size() + " en " + APP_NAME );

                    movies.forEach( movie -> System.out.println( movie.getInfo() + "\n" ));
                }
                case REMOVE -> {
                    String term = ScannerUtils.inputText( "Titulo a eliminar: " );
                    Movie title = platform.searchByTitle( term );

                    if( title != null ) {
                        platform.delete( title );
                        System.out.println( term + " eliminado en " + APP_NAME  );
                    }
                    else {
                        System.out.println( term + " no existe en " + APP_NAME );
                    }

                    break;
                }
                case EXIT -> {
                    System.exit( 0 );
                    break;
                }
                default -> {
                    break;
                }
            }

        }
    }

    private static void addMovies( Platform platform ) {
        platform.add( new Movie( "The Odyssey", 150, "Fiction" ) );
        platform.add( new Movie( "Avengers: Doomsday", 160, "Action" ) );
        platform.add( new Movie( "Toy Story", 100, "Animation" ) );
        platform.add( new Movie( "Mickey 17", 219, "Fiction" ) );
        platform.add( new Movie( "Sinners", 215, "Terror" ) );
        platform.add( new Movie( "How to Train your Dragon", 125, "Fantasy" ) );
        platform.add( new Movie( "Inside Out 2", 136, "Animation" ) );
        platform.add( new Movie( "Gladiator 2", 228, "Action" ) );
        platform.add( new Movie( "Deadpool & Wolverine", 208, "Action" ) );
        platform.add( new Movie( "Oppenheimer", 301, "Drama" ) );
    }
}
