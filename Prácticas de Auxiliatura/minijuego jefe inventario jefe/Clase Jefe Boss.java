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

class Jefe extends Enemigo {
    private double multiplicadorDeDaño;

    public Jefe(String nombre, int puntosDeVida, int dañoBase, double multiplicadorDeDaño) {
        super(nombre, puntosDeVida, dañoBase);
        this.multiplicadorDeDaño = multiplicadorDeDaño;
    }

    public int ataqueCritico() {
        int dañoCritico = (int) (super.atacar() * multiplicadorDeDaño);
        System.out.println(getNombre() + " ha realizado un ataque crítico con daño: " + dañoCritico);
        return dañoCritico;
    }

    public void hablar() {
        System.out.println(getNombre() + ": ¡Te aplastaré como una hormiga antes de que puedas reaccionar!");
    }

    public String getNombre() {
        return "Jefe " + super.toString();
    }
}

public class JuegoConJefe {
    public static void main(String[] args) {
        Jefe jefe = new Jefe("Dragón Destructor", 100, 20, 1.5);

        System.out.println("El Jefe está listo para la batalla:");
        jefe.mostrarEstado();
        jefe.hablar();
        System.out.println();

        Enemigo enemigo = new Enemigo("Soldado", 50, 15);
        enemigo.mostrarEstado();
        
        if (jefe.estaVivo()) {
            int dañoJefe = jefe.ataqueCritico();
            enemigo.recibirDaño(dañoJefe);
            enemigo.mostrarEstado();
        }

        if (!enemigo.estaVivo()) {
            System.out.println("¡El enemigo ha sido derrotado por el jefe!");
        }
    }
}
