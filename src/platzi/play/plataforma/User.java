package platzi.play.plataforma;

import platzi.play.contenido.Movie;

import java.time.LocalDateTime;

public class User {
    // Atributos
    public String name;
    public String email;
    public String password;
    public LocalDateTime createdAt;

    // Métodos
    public void watch( Movie movie ){
        System.out.println( name + " esta viendo >>> " + movie.title );
    }

    public String getInfo() {
        return "Name: " + name +
                "\n Email: " + email +
                "\n Fecha de creación: " + createdAt.toString();
    }
}
