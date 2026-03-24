package platzi.play.plataforma;

import platzi.play.contenido.Movie;

import java.time.LocalDateTime;

public class User {
    // Atributos
    private String name;
    private String email;
    private String password;
    private final LocalDateTime createdAt;      // Es constante no cambia, por eso usamos final

    // Constructor
    public User( String name, String email ) {
        this.name = name;
        this.email = email;
        this.createdAt = LocalDateTime.now();
    }

    // Métodos
    public void watch( Movie movie ){
        System.out.println( name + " esta viendo >>> " + movie.getTitle() );
    }

    public String getInfo() {
        return "Name: " + name +
                "\n Email: " + email +
                "\n Password: " + password +
                "\n Fecha de creación: " + createdAt.toString();
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
