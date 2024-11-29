public interface Desafiante {
    void desafiarCarta(Carta otraCarta);
}

abstract class Carta {
    protected int valor;
    protected String palo;

    public Carta(int valor, String palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public abstract void jugar();
    
    public void mostrarCarta() {
        System.out.println("Valor: " + valor + ", Palo: " + palo);
    }
}

public interface Accionable {
    void realizarAccion();
}

class CartaNormal extends Carta {

    public CartaNormal(int valor, String palo) {
        super(valor, palo);
    }

    @Override
    public void jugar() {
        System.out.println("La carta normal ha sido jugada.");
    }
}

class CartaEspecial extends Carta implements Accionable, Desafiante {

    public CartaEspecial(int valor, String palo) {
        super(valor, palo);
    }

    @Override
    public void jugar() {
        System.out.println("La carta especial ha sido jugada.");
    }

    @Override
    public void realizarAccion() {
        System.out.println("La carta especial realiza una acción especial.");
    }

    @Override
    public void desafiarCarta(Carta otraCarta) {
        System.out.println("La carta especial desafía a la carta " + otraCarta.getClass().getSimpleName());
    }
}

public class JuegoDeCartas {
    public static void main(String[] args) {
        Carta carta1 = new CartaNormal(5, "Corazones");
        CartaEspecial carta2 = new CartaEspecial(10, "Diamantes");

        carta1.mostrarCarta();
        carta1.jugar();

        carta2.mostrarCarta();
        carta2.jugar();
        carta2.realizarAccion();
        carta2.desafiarCarta(carta1);
    }
}
