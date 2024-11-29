abstract class Vehiculo {
    protected String marca;
    protected String modelo;
    protected int velocidadMaxima;
    protected int kilometraje;

    public Vehiculo(String marca, String modelo, int velocidadMaxima) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;
        this.kilometraje = 0;
    }

    public abstract void acelerar();

    public void mostrarInfo() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Velocidad máxima: " + velocidadMaxima + " km/h");
        System.out.println("Kilometraje: " + kilometraje + " km");
    }

    public void acumularKilometraje(int kilometros) {
        kilometraje += kilometros;
        System.out.println("Kilometraje acumulado: " + kilometros + " km");
    }
}

public interface Turbo {
    void activarTurbo();
}

class Coche extends Vehiculo {

    public Coche(String marca, String modelo, int velocidadMaxima) {
        super(marca, modelo, velocidadMaxima);
    }

    @Override
    public void acelerar() {
        System.out.println("El coche está acelerando.");
        acumularKilometraje(10);
    }
}

class Moto extends Vehiculo implements Turbo {

    public Moto(String marca, String modelo, int velocidadMaxima) {
        super(marca, modelo, velocidadMaxima);
    }

    @Override
    public void acelerar() {
        System.out.println("La moto está acelerando.");
        acumularKilometraje(15);
    }

    @Override
    public void activarTurbo() {
        System.out.println("La moto ha activado el turbo!");
    }
}

public class Carreras {
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
