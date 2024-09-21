import java.util.Scanner;

public class FraccionesContinuas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el valor de N: ");
        int N = scanner.nextInt();
        
        int numerador = 1;
        int denominador = 1;

        for (int i = 1; i <= N; i++) {
            int nuevoNumerador = denominador;
            int nuevoDenominador = numerador + denominador;
            
            numerador = nuevoNumerador;
            denominador = nuevoDenominador;
        }
        
        System.out.println(numerador);
        scanner.close();
    }
}
