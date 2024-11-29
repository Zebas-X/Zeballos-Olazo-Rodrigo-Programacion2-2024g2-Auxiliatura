import java.util.Random;

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

    public boolean estaVivo() {
        return puntosDeVida > 0;
    }
}

class Mago extends Personaje {
    private int mana;

    public Mago(String nombre, int nivel, int puntosDeVida, int mana) {
        super(nombre, nivel, puntosDeVida);
        this.mana = mana;
    }

    public void lanzarHechizo(Personaje objetivo) {
        Random rand = new Random();
        int daño = rand.nextInt(11) + 10;
        System.out.println(getNombre() + " ha lanzado un hechizo.");
        objetivo.recibirDaño(daño);
    }

    public String getNombre() {
        return "Mago " + super.toString();
    }
}

class Guerrero extends Personaje {
    private int fuerza;

    public Guerrero(String nombre, int nivel, int puntosDeVida, int fuerza) {
        super(nombre, nivel, puntosDeVida);
        this.fuerza = fuerza;
    }

    public void atacar(Personaje objetivo) {
        Random rand = new Random();
        int daño = rand.nextInt(11) + 10;
        System.out.println(getNombre() + " ha atacado con fuerza.");
        objetivo.recibirDaño(daño);
    }

    public String getNombre() {
        return "Guerrero " + super.toString();
    }
}

public class JuegoCombate {
    public static void main(String[] args) {
        Random rand = new Random();
        
        Mago mago = new Mago("Gandalf", rand.nextInt(10) + 1, 100, 50);
        Guerrero guerrero = new Guerrero("Aragorn", rand.nextInt(10) + 1, 100, 60);

        System.out.println("¡Comienza el combate!");
        mago.mostrarEstado();
        guerrero.mostrarEstado();
        System.out.println();

        while (mago.estaVivo() && guerrero.estaVivo()) {
            if (mago.estaVivo()) {
                mago.lanzarHechizo(guerrero);
                guerrero.mostrarEstado();
                System.out.println();
            }

            if (guerrero.estaVivo()) {
                guerrero.atacar(mago);
                mago.mostrarEstado();
                System.out.println();
            }
        }

        if (mago.estaVivo()) {
            System.out.println("¡El Mago ha ganado el combate!");
        } else if (guerrero.estaVivo()) {
            System.out.println("¡El Guerrero ha ganado el combate!");
        }
    }
}
