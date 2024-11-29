import java.util.ArrayList;

public class Inventario {
    private ArrayList<String> items;

    public Inventario() {
        this.items = new ArrayList<>();
    }

    public void agregarItem(String item) {
        items.add(item);
        System.out.println("Se ha agregado el ítem: " + item);
    }

    public void mostrarItems() {
        System.out.println("Inventario:");
        if (items.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            for (String item : items) {
                System.out.println("- " + item);
            }
        }
    }
}

class Personaje {
    private String nombre;
    private int nivel;
    private int puntosDeVida;
    private Inventario inventario;

    public Personaje(String nombre, int nivel, int puntosDeVida) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosDeVida = puntosDeVida;
        this.inventario = new Inventario();
    }

    public void mostrarEstado() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Nivel: " + nivel);
        System.out.println("Puntos de Vida: " + puntosDeVida);
        inventario.mostrarItems();
    }

    public void recibirDaño(int daño) {
        puntosDeVida -= daño;
        if (puntosDeVida < 0) {
            puntosDeVida = 0;
        }
        System.out.println(nombre + " ha recibido " + daño + " puntos de daño.");
    }

    public void curar() {
        puntosDeVida += 20;
        System.out.println(nombre + " se ha curado. +20 puntos de vida.");
    }

    public void agregarItem(String item) {
        inventario.agregarItem(item);
    }

    public static void main(String[] args) {
        Personaje personaje = new Personaje("Mago", 10, 150);

        personaje.mostrarEstado();

        personaje.agregarItem("Poción de vida");
        personaje.agregarItem("Espada mágica");

        personaje.mostrarEstado();

        personaje.recibirDaño(50);
        personaje.curar();

        personaje.mostrarEstado();
    }
}
