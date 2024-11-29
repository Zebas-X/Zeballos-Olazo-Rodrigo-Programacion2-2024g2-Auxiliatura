class Personaje {
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
}

class Mago extends Personaje {
    private int mana;

    public Mago(String nombre, int nivel, int puntosDeVida, int mana) {
        super(nombre, nivel, puntosDeVida);
        this.mana = mana;
    }

    public void lanzarHechizo() {
        if (mana > 0) {
            System.out.println(getNombre() + " ha lanzado un hechizo mágico.");
            mana -= 10;
        } else {
            System.out.println(getNombre() + " no tiene suficiente maná para lanzar un hechizo.");
        }
    }

    @Override
    public void mostrarEstado() {
        super.mostrarEstado();
        System.out.println("Maná: " + mana);
    }
}

class Arquero extends Personaje {
    private int destreza;

    public Arquero(String nombre, int nivel, int puntosDeVida, int destreza) {
        super(nombre, nivel, puntosDeVida);
        this.destreza = destreza;
    }

    public void dispararFlecha() {
        System.out.println(getNombre() + " ha disparado una flecha con precisión.");
    }

    @Override
    public void mostrarEstado() {
        super.mostrarEstado();
        System.out.println("Destreza: " + destreza);
    }
}

class Guerrero extends Personaje {
    private int fuerza;

    public Guerrero(String nombre, int nivel, int puntosDeVida, int fuerza) {
        super(nombre, nivel, puntosDeVida);
        this.fuerza = fuerza;
    }

    public void atacar() {
        System.out.println(getNombre() + " ha realizado un poderoso ataque con fuerza: " + fuerza);
    }

    @Override
    public void mostrarEstado() {
        super.mostrarEstado();
        System.out.println("Fuerza: " + fuerza);
    }
}

public class Juego {
    public static void main(String[] args) {
        Mago mago = new Mago("Gandalf", 10, 100, 50);
        mago.mostrarEstado();
        mago.lanzarHechizo();

        Arquero arquero = new Arquero("Legolas", 8, 90, 70);
        arquero.mostrarEstado();
        arquero.dispararFlecha();

        Guerrero guerrero = new Guerrero("Aragorn", 12, 120, 80);
        guerrero.mostrarEstado();
        guerrero.atacar();
    }
}
