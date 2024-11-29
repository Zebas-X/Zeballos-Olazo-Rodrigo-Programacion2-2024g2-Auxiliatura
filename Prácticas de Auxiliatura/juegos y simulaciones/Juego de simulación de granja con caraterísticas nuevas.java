abstract class Animal {
    protected String nombre;
    protected int edad;
    protected boolean alimentado;

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.alimentado = false;
    }

    public abstract void hacerSonido();

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Alimentado: " + (alimentado ? "Sí" : "No"));
    }

    public void alimentar() {
        alimentado = true;
        System.out.println("El animal " + nombre + " ha sido alimentado.");
    }
}

public interface Productor {
    void producir();
}

class Vaca extends Animal implements Productor {

    public Vaca(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void hacerSonido() {
        System.out.println("La vaca " + nombre + " está diciendo: ¡Muuu!");
    }

    @Override
    public void producir() {
        System.out.println("La vaca " + nombre + " está produciendo leche.");
    }
}

class Oveja extends Animal implements Productor {

    public Oveja(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void hacerSonido() {
        System.out.println("La oveja " + nombre + " está diciendo: ¡Beeee!");
    }

    @Override
    public void producir() {
        System.out.println("La oveja " + nombre + " está produciendo lana.");
    }
}

public class Granjas {
    public static void main(String[] args) {
        Vaca vaca = new Vaca("Lola", 5);
        Oveja oveja = new Oveja("Dolly", 3);

        vaca.mostrarInfo();
        vaca.hacerSonido();
        vaca.producir();
        vaca.alimentar();

        oveja.mostrarInfo();
        oveja.hacerSonido();
        oveja.producir();
        oveja.alimentar();
    }
}
