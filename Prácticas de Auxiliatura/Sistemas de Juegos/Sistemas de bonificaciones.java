@FunctionalInterface
public interface CalculadoraBonificacion {
    int calcular(int puntosBase);
}

public class Jugador {
    private String nombre;
    private int puntos;

    public Jugador(String nombre, int puntos) {
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public void aplicarBonificacion(CalculadoraBonificacion calculadora) {
        puntos = calculadora.calcular(puntos);
    }

    public void mostrarInfo() {
        System.out.println("Jugador: " + nombre + " | Puntos: " + puntos);
    }
}

public class Main {
    public static void main(String[] args) {
        Jugador jugador = new Jugador("Carlos", 100);

        jugador.mostrarInfo();

        CalculadoraBonificacion bonificacionDobles = puntosBase -> puntosBase * 2;

        CalculadoraBonificacion bonificacionExtra = puntosBase -> puntosBase + 50;

        jugador.aplicarBonificacion(bonificacionDobles);
        jugador.mostrarInfo();

        jugador.aplicarBonificacion(bonificacionExtra);
        jugador.mostrarInfo();
    }
}
