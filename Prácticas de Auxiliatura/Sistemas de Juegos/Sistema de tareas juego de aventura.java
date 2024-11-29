@FunctionalInterface
public interface Tarea {
    void ejecutar();
}

import java.util.ArrayList;
import java.util.List;

public class Aventura {
    private List<Tarea> tareas;

    public Aventura() {
        tareas = new ArrayList<>();
    }

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    public void iniciar() {
        for (Tarea tarea : tareas) {
            tarea.ejecutar();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Aventura aventura = new Aventura();

        aventura.agregarTarea(() -> System.out.println("Explorar el bosque"));
        aventura.agregarTarea(() -> System.out.println("Recoger hierbas medicinales"));
        aventura.agregarTarea(() -> System.out.println("Derrotar al dragón"));

        aventura.iniciar();
    }
}
