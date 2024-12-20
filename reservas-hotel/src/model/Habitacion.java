package model;

import java.util.ArrayList;
import java.util.List;

public class Habitacion implements Observable {
    private Integer numero;
    private List<Observer> observers = new ArrayList<>();

    public Habitacion(Integer numero) {
        this.numero = numero;
    }

    public Habitacion() {
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void asignarHuesped(Huesped huesped) {
        notifyObservers("Habitación " + numero + " asignada al huésped " + huesped.getNombre());
    }

    public void liberarHabitacion() {
        notifyObservers("La habitación " + numero + " ha sido liberada.");
    }
}