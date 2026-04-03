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
    public static final int SHOW_POPULAR = 5;
    public static final int SHOW_SHORTER = 6;
    public static final int SHOW_LONGER = 7;
    public static final int SHOW_THE_BEST = 8;
    public static final int REMOVE = 9;
    public static final int EXIT = 10;

    public static void main(String[] args) {
        System.out.println( APP_NAME + " v" + VERSION );

        // Creamos una nueva Plataforma
        Platform platform = new Platform( APP_NAME );

        // Cargar películas
        addMovies( platform );

        // Información General
        System.out.println( "Más de " + platform.getTotalDuration() + " minutos de contenido" );

        // Menu interactivo usando un while
        while( true ) {
            int option = ScannerUtils.inputInt("""
                    Menu de navegación:
                    1. Agregar contenido
                    2. Mostrar todo
                    3. Buscar por titulo
                    4. Buscar por genero
                    5. Mostrar
                    6. Mostrar menor duración
                    7. Mostrar mayor duración
                    8. Mostrar las mejores (+4.5)
                    9. Eliminar contenido
                    10. Salir
                    Ingresa una de las opciones:
                    """);
            System.out.println("Opcion elegida: " + option);

            // Usando switch
            switch( option ) {
                case ADD -> {
                    System.out.println( "*** Agregar película ***" );

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
                }
                case SHOW -> {
                    System.out.println( "*** Listado de películas disponibles ***" );

                    List<String> titles = platform.getTitles();
                    titles.forEach( System.out::println );      // System.out::println equivale a title -> System.out.println( title )
                }
                case SEARCH_BY_TITLE -> {
                    System.out.println( "*** Buscar película ***" );

                    String term = ScannerUtils.inputText( "Buscar por titulo: " );
                    Movie movie = platform.searchByTitle( term );

                    System.out.println( "*** Resultados de búsqueda por titulo ***" );

                    if( movie != null ) {
                        System.out.println( movie.getInfo() );
                    }
                    else {
                        System.out.println( term + " no existe en " + APP_NAME );
                    }
                }
                case SEARCH_BY_GENRE -> {
                    System.out.println( "*** Buscar película ***" );

                    String term = ScannerUtils.inputText( "Buscar por genero: " );

                    System.out.println( "*** Resultados de búsqueda por genero ***" );

                    List<Movie> movies = platform.searchByGenre( term );
                    System.out.println( "Se han encontrado " + movies.size() + " en " + APP_NAME );

                    movies.forEach( movie -> System.out.println( movie.getInfo() + "\n" ));
                }
                case SHOW_POPULAR -> {
                    System.out.println( "*** Listado de películas populares ***" );
                    int quantity = ScannerUtils.inputInt( "Cantidad de resultados a mostrar" );

                    List<Movie> popularMovies = platform.getPopularMovies( quantity );
                    popularMovies.forEach( movie -> System.out.println( movie.getInfo() + "\n" ) );
                }
                case SHOW_SHORTER -> {
                    System.out.println( "*** La película mas corta ***" );
                    Movie shorterMovie = platform.getShorterMovie();
                    System.out.println( shorterMovie.getInfo() );
                }
                case SHOW_LONGER -> {
                    System.out.println( "*** La película mas larga ***" );
                    Movie longerMovie = platform.getLongerMovie();
                    System.out.println( longerMovie.getInfo() );
                }
                case SHOW_THE_BEST -> {
                    System.out.println( "*** Las mejores películas (+4.5) ");
                    List<Movie> theBestMovies = platform.getTheBestMovies();

                    System.out.println( "Son " + theBestMovies.size() + " con mas de 4.5 en " + APP_NAME );
                    theBestMovies.forEach( movie -> System.out.println( movie.getInfo() + "\n" ) );
                }
                case REMOVE -> {
                    System.out.println( "*** Eliminar película ***" );

                    String term = ScannerUtils.inputText( "Titulo a eliminar: " );
                    Movie title = platform.searchByTitle( term );

                    if( title != null ) {
                        platform.delete( title );
                        System.out.println( term + " eliminado en " + APP_NAME  );
                    }
                    else {
                        System.out.println( term + " no existe en " + APP_NAME );
                    }
                }
                case EXIT -> System.exit( 0 );
                default -> {
                    System.out.println( "El valor seleccionado no se encuentra en el menu" );
                    break;
                }
            }

        }
    }

    private static void addMovies( Platform platform ) {
        platform.add( new Movie( "The Odyssey", 150, "Fiction", 4.0 ) );
        platform.add( new Movie( "Avengers: Doomsday", 160, "Action", 4.3 ) );
        platform.add( new Movie( "Toy Story", 100, "Animation", 3.8 ) );
        platform.add( new Movie( "Mickey 17", 219, "Fiction", 3.6 ) );
        platform.add( new Movie( "Sinners", 215, "Terror", 3.0 ) );
        platform.add( new Movie( "How to Train your Dragon", 125, "Fantasy", 4.0 ) );
        platform.add( new Movie( "Inside Out 2", 136, "Animation", 4.25 ) );
        platform.add( new Movie( "Gladiator 2", 228, "Action", 4.5 ) );
        platform.add( new Movie( "Deadpool & Wolverine", 208, "Action", 4.7 ) );
        platform.add( new Movie( "Oppenheimer", 301, "Drama", 4.72 ) );
    }
}
