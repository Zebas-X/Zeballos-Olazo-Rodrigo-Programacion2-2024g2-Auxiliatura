import java.util.Scanner;

public class DuracionDiscurso {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el número de directores: ");
        int N = scanner.nextInt();
        System.out.println("Ingrese la duración máxima de la reunión: ");
        int K = scanner.nextInt();

        int tiempoMaximo = (K - (N - 1)) / N;

        tiempoMaximo = Math.max(tiempoMaximo, 1);

        System.out.println("El tiempo máximo de discurso de cada director es: " + tiempoMaximo + " minutos");
        
        scanner.close();
    }
}
