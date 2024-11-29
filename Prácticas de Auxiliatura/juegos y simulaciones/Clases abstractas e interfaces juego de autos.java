abstract class Vehiculo {
    protected String marca;
    protected String modelo;
    protected int velocidadMaxima;

    public Vehiculo(String marca, String modelo, int velocidadMaxima) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;
    }

    public abstract void acelerar();

    public void mostrarInfo() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Velocidad máxima: " + velocidadMaxima + " km/h");
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
        System.out.println("El coche " + marca + " " + modelo + " está acelerando.");
    }
}

class Moto extends Vehiculo implements Turbo {
    
    public Moto(String marca, String modelo, int velocidadMaxima) {
        super(marca, modelo, velocidadMaxima);
    }

    @Override
    public void acelerar() {
        System.out.println("La moto " + marca + " " + modelo + " está acelerando.");
    }

    @Override
    public void activarTurbo() {
        System.out.println("La moto " + marca + " " + modelo + " ha activado el turbo.");
    }
}

public class JuegoDeCarreras {
    public static void main(String[] args) {
        Coche coche = new Coche("Toyota", "Corolla", 180);
        Moto moto = new Moto("Yamaha", "R1", 300);

        System.out.println("Información del coche:");
        coche.mostrarInfo();
        coche.acelerar();
        
        System.out.println();
        
        System.out.println("Información de la moto:");
        moto.mostrarInfo();
        moto.acelerar();
        moto.activarTurbo();
    }
}
