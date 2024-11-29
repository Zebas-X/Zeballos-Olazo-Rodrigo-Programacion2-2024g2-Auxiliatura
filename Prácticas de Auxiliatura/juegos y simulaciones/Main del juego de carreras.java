public class Main {
    public static void main(String[] args) {
        Vehiculo coche = new Coche("Toyota", "Corolla", 180);
        Vehiculo moto = new Moto("Yamaha", "R1", 220);

        coche.mostrarInfo();
        coche.acelerar();

        moto.mostrarInfo();
        moto.acelerar();
        ((Moto) moto).activarTurbo();
    }
}
