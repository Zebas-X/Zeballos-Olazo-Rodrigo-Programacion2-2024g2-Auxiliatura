abstract class Carta {
    protected int valor;
    protected String palo;

    public Carta(int valor, String palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public abstract void jugar();

    public void mostrarCarta() {
        System.out.println("Carta: " + valor + " de " + palo);
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
        System.out.println("La carta normal " + valor + " de " + palo + " ha sido jugada.");
    }
}

class CartaEspecial extends Carta implements Accionable {
    
    public CartaEspecial(int valor, String palo) {
        super(valor, palo);
    }

    @Override
    public void jugar() {
        System.out.println("La carta especial " + valor + " de " + palo + " ha sido jugada.");
        realizarAccion();
    }

    @Override
    public void realizarAccion() {
        System.out.println("Acción especial: ¡Roba una carta del mazo!");
    }
}

public class JuegoDeCartas {
    public static void main(String[] args) {
        CartaNormal cartaNormal = new CartaNormal(7, "Corazones");
        CartaEspecial cartaEspecial = new CartaEspecial(10, "Picas");

        cartaNormal.mostrarCarta();
        cartaNormal.jugar();
        
        System.out.println();
        
        cartaEspecial.mostrarCarta();
        cartaEspecial.jugar();
    }
}
