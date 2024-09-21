import java.util.Scanner;

public class Joyero {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tamaño de la matriz (N): ");
        int N = scanner.nextInt();
        int[][] original = new int[N][N];

        System.out.println("Ingrese los números de perlas en cada cajita (filas y columnas): ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                original[i][j] = scanner.nextInt();
            }
        }

        int rotaciones = comprobarRotaciones(original, N);

        System.out.println("Número de rotaciones necesarias: " + rotaciones);
        scanner.close();
    }

    public static int comprobarRotaciones(int[][] original, int N) {
        for (int r = 0; r < 4; r++) {
            if (r == 0) {
                if (sonMatricesIguales(original, original)) {
                    return r;
                }
            } else {
                original = rotarAntihorario(original, N);
                if (sonMatricesIguales(original, rotarAntihorario(original, N))) {
                    return r;
                }
            }
        }
        return 0;
    }

    public static int[][] rotarAntihorario(int[][] matriz, int N) {
        int[][] rotada = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rotada[N - j - 1][i] = matriz[i][j];
            }
        }
        return rotada;
    }

    public static boolean sonMatricesIguales(int[][] matriz1, int[][] matriz2) {
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                if (matriz1[i][j] != matriz2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
