import java.util.HashMap;
import java.util.Scanner;

public class FormatoFecha {

    public static void main(String[] args) {
        HashMap<String, String> meses = new HashMap<>();
        meses.put("enero", "01");
        meses.put("febrero", "02");
        meses.put("marzo", "03");
        meses.put("abril", "04");
        meses.put("mayo", "05");
        meses.put("junio", "06");
        meses.put("julio", "07");
        meses.put("agosto", "08");
        meses.put("septiembre", "09");
        meses.put("octubre", "10");
        meses.put("noviembre", "11");
        meses.put("diciembre", "12");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una fecha en formato 'dia de mes, año' (por ejemplo: 4 de junio, 2004):");
        String entrada = scanner.nextLine();

        String[] partes = entrada.split(" de |, ");
        
        if (partes.length != 3) {
            System.out.println("Formato de fecha incorrecto. Asegúrese de seguir el formato solicitado.");
            return;
        }

        String dia = partes[0].trim();
        String mes = meses.get(partes[1].toLowerCase().trim());
        String anio = partes[2].trim();

        if (!dia.matches("\\d+") || !anio.matches("\\d+")) {
            System.out.println("El día y el año deben ser numéricos.");
            return;
        }

        if (mes == null) {
            System.out.println("Mes no válido. Asegúrese de escribir el nombre del mes correctamente.");
            return;
        }

        String diaFormateado = String.format("%02d", Integer.parseInt(dia));

        System.out.println(diaFormateado + "/" + mes + "/" + anio);

        scanner.close();
    }
}