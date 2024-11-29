public class Main {
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
