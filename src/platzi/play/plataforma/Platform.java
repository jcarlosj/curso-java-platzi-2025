package platzi.play.plataforma;

import platzi.play.contenido.Movie;

import java.util.ArrayList;
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

    public void showTitles() {
        System.out.println( "Listado títulos" );
        for (int i = 0; i < content.size(); i++) {
            System.out.println( i + 1 +". " + content.get( i ).getTitle() );
        }
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
}
