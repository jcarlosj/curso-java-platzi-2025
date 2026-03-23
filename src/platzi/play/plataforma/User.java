package platzi.play.plataforma;

import platzi.play.contenido.Movie;

public class User {
    // Atributos
    public String name;
    public String email;
    public String password;

    // Métodos
    public void watch( Movie movie ){
        System.out.println( name + " esta viendo >>> " + movie.title );
    }
}
