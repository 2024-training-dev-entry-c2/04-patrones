package model;

public class Huesped implements Observer {
    private String nombre;

    public Huesped(String nombre) {
        this.nombre = nombre;
    }

    public Huesped() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void update(String message) {
        System.out.println("Huesped " + nombre + " recibió notificación: " + message);
    }
}