public class Personaje {
    private String nombre;
    private int nivel;
    private int puntosDeVida;

    public Personaje(String nombre, int nivel, int puntosDeVida) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosDeVida = puntosDeVida;
    }

    public void mostrarEstado() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Nivel: " + nivel);
        System.out.println("Puntos de Vida: " + puntosDeVida);
    }

    public void recibirDaño(int daño) {
        if (daño < 0) {
            System.out.println("El daño no puede ser negativo.");
            return;
        }
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

    public static void main(String[] args) {
        Personaje personaje = new Personaje("Guerrero", 5, 100);

        personaje.mostrarEstado();

        personaje.recibirDaño(30);
        personaje.mostrarEstado();

        personaje.curar();
        personaje.mostrarEstado();
    }
}
