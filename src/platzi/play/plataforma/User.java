package platzi.play.plataforma;

import platzi.play.contenido.Movie;

import java.time.LocalDateTime;

public class User {
    // Atributos
    public String name;
    public String email;
    public String password;
    public LocalDateTime createdAt;

    // Constructor
    public User( String name, String email ) {
        this.name = name;
        this.email = email;
        this.createdAt = LocalDateTime.now();
    }

    // Métodos
    public void watch( Movie movie ){
        System.out.println( name + " esta viendo >>> " + movie.title );
    }

    public String getInfo() {
        return "Name: " + name +
                "\n Email: " + email +
                "\n Password: " + password +
                "\n Fecha de creación: " + createdAt.toString();
    }
}
