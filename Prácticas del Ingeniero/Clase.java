public class Vector2D {
    private double x;
    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D sumar(Vector2D v) {
        return new Vector2D(this.x + v.x, this.y + v.y);
    }

    public Vector2D restar(Vector2D v) {
        return new Vector2D(this.x - v.x, this.y - v.y);
    }

    public Vector2D multiplicar(double escalar) {
        return new Vector2D(this.x * escalar, this.y * escalar);
    }

    public Vector2D dividir(double escalar) {
        if (escalar != 0) {
            return new Vector2D(this.x / escalar, this.y / escalar);
        } else {
            throw new ArithmeticException("División por cero no permitida.");
        }
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    public static void main(String[] args) {
        Vector2D vector1 = new Vector2D(2, 3);
        Vector2D vector2 = new Vector2D(1, 5);

        Vector2D suma = vector1.sumar(vector2);
        System.out.println("Suma: " + suma);

        Vector2D resta = vector1.restar(vector2);
        System.out.println("Resta: " + resta);

        double escalar = 2.5;
        Vector2D multiplicacionEscalar = vector1.multiplicar(escalar);
        System.out.println("Multiplicación escalar: " + multiplicacionEscalar);

        Vector2D divisionEscalar = vector1.dividir(escalar);
        System.out.println("División escalar: " + divisionEscalar);
    }
}