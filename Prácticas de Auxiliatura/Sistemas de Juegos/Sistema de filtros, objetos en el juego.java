@FunctionalInterface
public interface FiltroObjeto {
    boolean filtrar(Objeto objeto);
}

public class Objeto {
    private String nombre;
    private int peso;

    public Objeto(String nombre, int peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPeso() {
        return peso;
    }

    public void mostrarInfo() {
        System.out.println("Objeto: " + nombre + " | Peso: " + peso);
    }
}

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Objeto> objetos;

    public Inventario() {
        objetos = new ArrayList<>();
    }

    public void agregarObjeto(Objeto objeto) {
        objetos.add(objeto);
    }

    public List<Objeto> filtrarObjetos(FiltroObjeto filtro) {
        List<Objeto> resultado = new ArrayList<>();
        for (Objeto objeto : objetos) {
            if (filtro.filtrar(objeto)) {
                resultado.add(objeto);
            }
        }
        return resultado;
    }
}

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        Objeto espada = new Objeto("Espada", 10);
        Objeto escudo = new Objeto("Escudo", 15);
        Objeto pocion = new Objeto("Poción", 1);
        inventario.agregarObjeto(espada);
        inventario.agregarObjeto(escudo);
        inventario.agregarObjeto(pocion);

        FiltroObjeto filtroPeso = objeto -> objeto.getPeso() > 5;
        List<Objeto> objetosPesados = inventario.filtrarObjetos(filtroPeso);

        System.out.println("Objetos con peso mayor a 5:");
        for (Objeto objeto : objetosPesados) {
            objeto.mostrarInfo();
        }

        FiltroObjeto filtroNombre = objeto -> objeto.getNombre().startsWith("E");
        List<Objeto> objetosE = inventario.filtrarObjetos(filtroNombre);

        System.out.println("\nObjetos cuyo nombre empieza con 'E':");
        for (Objeto objeto : objetosE) {
            objeto.mostrarInfo();
        }
    }
}
