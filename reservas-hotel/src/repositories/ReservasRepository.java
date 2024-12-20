package repositories;

import model.Habitacion;
import model.Huesped;

import java.util.HashMap;
import java.util.Map;

public class ReservasRepository {

    private static ReservasRepository instancia;

    private Map<Integer, Huesped> reservas;

    private ReservasRepository() {
        this.reservas = new HashMap<>();
    }

    public static synchronized ReservasRepository getInstancia() {
        if (instancia == null) {
            instancia = new ReservasRepository();
        }
        return instancia;
    }

    public boolean agregarReserva(Habitacion habitacion, Huesped huesped) {
        if (!reservas.containsKey(habitacion.getNumero())) {
            reservas.put(habitacion.getNumero(), huesped);

            return true;
        }
        return false;
    }

    public boolean eliminarReserva(Habitacion habitacion) {
        if (reservas.containsKey(habitacion.getNumero())) {
            habitacion.notifyObservers("La reserva de la habitación " + habitacion.getNumero() + " ha sido cancelada.");
            reservas.remove(habitacion.getNumero());
            return true;
        }
        return false;
    }

    public Map<Integer, Huesped> obtenerReservas() {
        return reservas;
    }
}