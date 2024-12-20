import model.Habitacion;
import model.Huesped;

public class Main {
    public static void main(String[] args) {

        Habitacion habitacion101 = new Habitacion(101);

        Huesped juan = new Huesped("Juan");
        Huesped maria = new Huesped("Maria");
        Huesped pedro = new Huesped("Pedro");

        habitacion101.addObserver(juan);
        habitacion101.addObserver(maria);
        habitacion101.addObserver(pedro);

        System.out.println("=== Evento: Reservar habitación ===");
        habitacion101.asignarHuesped(pedro);

        System.out.println("\n--- Maria ya no quiere recibir notificaciones ---");
        habitacion101.removeObserver(maria);

        System.out.println("\n=== Evento: Liberar habitación ===");
        habitacion101.liberarHabitacion();
    }
}