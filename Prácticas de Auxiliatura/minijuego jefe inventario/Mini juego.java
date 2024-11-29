import java.util.Scanner;

class Enemigo {
    private String nombre;
    private int puntosDeVida;
    private int dañoBase;

    public Enemigo(String nombre, int puntosDeVida, int dañoBase) {
        this.nombre = nombre;
        this.puntosDeVida = puntosDeVida;
        this.dañoBase = dañoBase;
    }

    public int atacar() {
        return dañoBase;
    }

    public void recibirDaño(int daño) {
        puntosDeVida -= daño;
        if (puntosDeVida < 0) {
            puntosDeVida = 0;
        }
        System.out.println(nombre + " ha recibido " + daño + " puntos de daño.");
    }

    public boolean estaVivo() {
        return puntosDeVida > 0;
    }

    public void mostrarEstado() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Puntos de vida: " + puntosDeVida);
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
        System.out.println("Puntos de vida: " + puntosDeVida);
    }

    public void recibirDaño(int daño) {
        puntosDeVida -= daño;
        if (puntosDeVida < 0) {
            puntosDeVida = 0;
        }
    }

    public void curar() {
        puntosDeVida += 20;
        System.out.println(nombre + " se ha curado 20 puntos de vida.");
    }

    public Inventario getInventario() {
        return inventario;
    }
}

class Inventario {
    private String[] items;
    private int numItems;

    public Inventario() {
        this.items = new String[10];
        this.numItems = 0;
    }

    public void agregarItem(String item) {
        if (numItems < items.length) {
            items[numItems++] = item;
            System.out.println(item + " ha sido añadido al inventario.");
        } else {
            System.out.println("El inventario está lleno.");
        }
    }

    public void mostrarItems() {
        System.out.println("Items en el inventario:");
        for (int i = 0; i < numItems; i++) {
            System.out.println("- " + items[i]);
        }
    }
}

class Mago extends Personaje {
    private int mana;

    public Mago(String nombre, int nivel, int puntosDeVida, int mana) {
        super(nombre, nivel, puntosDeVida);
        this.mana = mana;
    }

    public void lanzarHechizo() {
        if (mana >= 10) {
            mana -= 10;
            System.out.println("¡" + super.nombre + " ha lanzado un hechizo!");
        } else {
            System.out.println(super.nombre + " no tiene suficiente maná para lanzar un hechizo.");
        }
    }

    public void mostrarEstado() {
        super.mostrarEstado();
        System.out.println("Mana: " + mana);
    }
}

class Guerrero extends Personaje {
    private int fuerza;

    public Guerrero(String nombre, int nivel, int puntosDeVida, int fuerza) {
        super(nombre, nivel, puntosDeVida);
        this.fuerza = fuerza;
    }

    public void atacar() {
        System.out.println(super.nombre + " ha realizado un ataque con fuerza.");
    }
}

class Jefe extends Enemigo {
    private double multiplicadorDeDaño;

    public Jefe(String nombre, int puntosDeVida, int dañoBase, double multiplicadorDeDaño) {
        super(nombre, puntosDeVida, dañoBase);
        this.multiplicadorDeDaño = multiplicadorDeDaño;
    }

    public int ataqueCritico() {
        int dañoCritico = (int) (super.atacar() * multiplicadorDeDaño);
        System.out.println(super.nombre + " ha realizado un ataque crítico con daño: " + dañoCritico);
        return dañoCritico;
    }

    public void hablar() {
        System.out.println(super.nombre + ": ¡Te aplastaré como una hormiga antes de que puedas reaccionar!");
    }
}

public class MiniJuego {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Personaje mago = new Mago("Merlin", 5, 100, 50);
        Personaje guerrero = new Guerrero("Thor", 5, 100, 30);
        Enemigo zombie = new Enemigo("Zombie", 50, 10);
        Jefe jefe = new Jefe("Dragón Destructor", 100, 20, 2.0);

        System.out.println("Bienvenido al Mini Juego de Combate");
        System.out.println("Tienes un Mago y un Guerrero a tu disposición.");
        System.out.println("Elige qué personaje quieres jugar:");

        System.out.println("1. Mago");
        System.out.println("2. Guerrero");
        System.out.print("Elige un número: ");
        int eleccion = scanner.nextInt();

        Personaje jugador = (eleccion == 1) ? mago : guerrero;

        while (true) {
            System.out.println("\n¿Qué acción quieres realizar?");
            System.out.println("1. Atacar");
            System.out.println("2. Hablar");
            System.out.println("3. Ver estado");
            System.out.println("4. Curar");
            System.out.println("5. Ver inventario");
            System.out.print("Elige una opción: ");
            int accion = scanner.nextInt();

            switch (accion) {
                case 1:
                    if (jugador instanceof Mago) {
                        ((Mago) jugador).lanzarHechizo();
                    } else if (jugador instanceof Guerrero) {
                        ((Guerrero) jugador).atacar();
                    }
                    zombie.recibirDaño(20);
                    zombie.mostrarEstado();
                    break;
                case 2:
                    if (jugador instanceof Jefe) {
                        ((Jefe) jugador).hablar();
                    }
                    break;
                case 3:
                    jugador.mostrarEstado();
                    break;
                case 4:
                    jugador.curar();
                    break;
                case 5:
                    jugador.getInventario().mostrarItems();
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }

            if (!zombie.estaVivo()) {
                System.out.println("¡El zombie ha sido derrotado!");
                break;
            }
        }
        scanner.close();
    }
}
