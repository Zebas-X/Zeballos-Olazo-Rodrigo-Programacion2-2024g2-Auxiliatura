import java.util.*;

public class SistemaDeBotin {
    private static Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Map<String, Object>> botinTotal = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            Map<String, Object> botin = generarBotin();
            botinTotal.add(botin);
            imprimirBotin(botin);

            System.out.println("¿Desea continuar enfrentándose a enemigos? (si/no): ");
            String respuesta = scanner.nextLine();
            continuar = respuesta.equalsIgnoreCase("si");
        }

        System.out.println("\nResumen del botín obtenido:");
        for (Map<String, Object> b : botinTotal) {
            imprimirBotin(b);
        }

        scanner.close();
    }

    public static Map<String, Object> generarBotin() {
        String tipo = obtenerTipoBotin();
        String rareza = obtenerRarezaBotin();
        Map<String, Object> botin = new HashMap<>();
        botin.put("tipo", tipo);
        botin.put("rareza", rareza);
        botin.put("atributo_1", generarAtributo(tipo));
        botin.put("atributo_2", generarAtributo(tipo));
        botin.put("atributo_3", generarAtributo(tipo));
        return botin;
    }

    public static String obtenerTipoBotin() {
        String[] tipos = {"Arma", "Escudo", "Modificador"};
        return tipos[random.nextInt(tipos.length)];
    }

    public static String obtenerRarezaBotin() {
        String[] rarezas = {"Común", "Poco Común", "Raro", "Épico", "Legendario"};
        return rarezas[random.nextInt(rarezas.length)];
    }

    public static int generarAtributo(String tipo) {
        switch (tipo) {
            case "Arma":
                return random.nextInt(101);
            case "Escudo":
                return random.nextInt(101);
            case "Modificador":
                return random.nextInt(51) + 50;
            default:
                return 0;
        }
    }

    public static void imprimirBotin(Map<String, Object> botin) {
        System.out.println("¡Has encontrado un botín!");
        System.out.println("Tipo: " + botin.get("tipo"));
        System.out.println("Rareza: " + botin.get("rareza"));
        System.out.println("Atributo 1: " + botin.get("atributo_1"));
        System.out.println("Atributo 2: " + botin.get("atributo_2"));
        System.out.println("Atributo 3: " + botin.get("atributo_3"));
        System.out.println();
    }
}
