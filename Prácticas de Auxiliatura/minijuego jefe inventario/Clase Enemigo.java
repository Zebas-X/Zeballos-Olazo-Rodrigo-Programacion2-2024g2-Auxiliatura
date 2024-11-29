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

class Zombie extends Enemigo {
    public Zombie(String nombre, int puntosDeVida, int dañoBase) {
        super(nombre, puntosDeVida, dañoBase);
    }

    @Override
    public int atacar() {
        int dañoInfligido = super.atacar();
        recibirDaño(-5);
        System.out.println(getNombre() + " ha regenerado 5 puntos de vida.");
        return dañoInfligido;
    }

    public String getNombre() {
        return "Zombie " + super.toString();
    }
}

class Vampiro extends Enemigo {
    public Vampiro(String nombre, int puntosDeVida, int dañoBase) {
        super(nombre, puntosDeVida, dañoBase);
    }

    @Override
    public int atacar() {
        int dañoInfligido = super.atacar();
        int vidaRobada = dañoInfligido / 2;
        recibirDaño(-vidaRobada);
        System.out.println(getNombre() + " ha robado " + vidaRobada + " puntos de vida.");
        return dañoInfligido;
    }

    public String getNombre() {
        return "Vampiro " + super.toString();
    }
}

public class JuegoEnemigos {
    public static void main(String[] args) {
        Zombie zombie = new Zombie("Zombie 1", 50, 15);
        Vampiro vampiro = new Vampiro("Vampiro 1", 40, 20);

        System.out.println("Estado inicial de los enemigos:");
        zombie.mostrarEstado();
        vampiro.mostrarEstado();
        System.out.println();

        while (zombie.estaVivo() && vampiro.estaVivo()) {
            if (zombie.estaVivo()) {
                int dañoZombie = zombie.atacar();
                System.out.println("El Zombie inflige " + dañoZombie + " puntos de daño.");
                vampiro.recibirDaño(dañoZombie);
                vampiro.mostrarEstado();
            }

            if (vampiro.estaVivo()) {
                int dañoVampiro = vampiro.atacar();
                System.out.println("El Vampiro inflige " + dañoVampiro + " puntos de daño.");
                zombie.recibirDaño(dañoVampiro);
                zombie.mostrarEstado();
            }
            System.out.println();
        }

        if (zombie.estaVivo()) {
            System.out.println("¡El Zombie ha ganado el combate!");
        } else if (vampiro.estaVivo()) {
            System.out.println("¡El Vampiro ha ganado el combate!");
        }
    }
}
