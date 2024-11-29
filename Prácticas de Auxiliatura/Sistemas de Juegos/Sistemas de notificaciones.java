import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
public interface EventoNotificacion {
    void notificar(String mensaje);
}

class Evento {
    private String nombre;
    private List<EventoNotificacion> notificaciones;

    public Evento(String nombre) {
        this.nombre = nombre;
        this.notificaciones = new ArrayList<>();
    }

    public void registrarNotificacion(EventoNotificacion notificacion) {
        notificaciones.add(notificacion);
    }

    public void activar() {
        for (EventoNotificacion notificacion : notificaciones) {
            notificacion.notificar("Evento activado: " + nombre);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Evento evento = new Evento("Batalla Final");

        evento.registrarNotificacion(mensaje -> System.out.println("Notificación 1: " + mensaje));
        evento.registrarNotificacion(mensaje -> System.out.println("Notificación 2: " + mensaje));
        evento.registrarNotificacion(mensaje -> System.out.println("Notificación 3: " + mensaje));

        evento.activar();
    }
}
