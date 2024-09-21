import java.util.HashMap;
import java.util.Scanner;

public class FormatoFecha {

    public static void main(String[] args) {
        HashMap<String, Integer> meses = new HashMap<>();
        meses.put("enero", 31);
        meses.put("febrero", 28); 
        meses.put("marzo", 31);
        meses.put("abril", 30);
        meses.put("mayo", 31);
        meses.put("junio", 30);
        meses.put("julio", 31);
        meses.put("agosto", 31);
        meses.put("septiembre", 30);
        meses.put("octubre", 31);
        meses.put("noviembre", 30);
        meses.put("diciembre", 31);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una fecha en formato 'dia de mes, año'");
        String entrada = scanner.nextLine();

        String[] partes = entrada.split(" de |, ");
        
        if (partes.length != 3) {
            System.out.println("Formato de fecha incorrecto. Asegúrese de seguir el formato solicitado.");
            return;
        }

        String diaStr = partes[0].trim();
        String mesStr = partes[1].toLowerCase().trim();
        String anioStr = partes[2].trim();

        if (!diaStr.matches("\\d+") || !anioStr.matches("\\d+")) {
            System.out.println("El día y el año deben ser numéricos.");
            return;
        }

        int dia = Integer.parseInt(diaStr);
        int anio = Integer.parseInt(anioStr);
        
        Integer diasMaximos = meses.get(mesStr);
        if (diasMaximos == null) {
            System.out.println("Mes no válido. Asegúrese de escribir el nombre del mes correctamente.");
            return;
        }

        if (mesStr.equals("febrero") && esBisiesto(anio)) {
            diasMaximos = 29;
        }

        if (dia < 1 || dia > diasMaximos) {
            System.out.println("El día " + dia + " no es válido para el mes de " + mesStr + ".");
            return;
        }

        String diaFormateado = String.format("%02d", dia);
        String mesNumerico = String.format("%02d", obtenerNumeroMes(mesStr));

        System.out.println(diaFormateado + "/" + mesNumerico + "/" + anio);

        scanner.close();
    }

    private static boolean esBisiesto(int año) {
        return (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0);
    }

    private static int obtenerNumeroMes(String mes) {
        switch (mes) {
            case "enero": return 1;
            case "febrero": return 2;
            case "marzo": return 3;
            case "abril": return 4;
            case "mayo": return 5;
            case "junio": return 6;
            case "julio": return 7;
            case "agosto": return 8;
            case "septiembre": return 9;
            case "octubre": return 10;
            case "noviembre": return 11;
            case "diciembre": return 12;
            default: return -1;
        }
    }
}