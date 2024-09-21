import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ContarLetras {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> palabras = new ArrayList<>();

        System.out.println("Ingrese palabras (escriba 'fin' para acabar):");
        while (true) {
            String palabra = scanner.nextLine();
            if (palabra.equalsIgnoreCase("fin")) {
                break;
            }
            palabras.add(palabra);
        }

        char letra = 'm';
        int cantidadTotal = contarLetrasEnPalabras(palabras, letra);

        System.out.println("Total de letras '" + letra + "' encontradas: " + cantidadTotal);

        scanner.close();
    }

    public static int contarLetrasEnPalabras(List<String> palabras, char letra) {
        int contador = 0;

        for (String palabra : palabras) {
            for (char c : palabra.toLowerCase().toCharArray()) {
                if (c == Character.toLowerCase(letra)) {
                    contador++;
                }
            }
        }

        return contador;
    }
}