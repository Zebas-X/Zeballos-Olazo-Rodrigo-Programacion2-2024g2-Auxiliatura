import java.util.*;

public class MaximoLexicograficamente {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el número de elementos N: ");
        int N = scanner.nextInt();
        
        int[] nums = new int[N];
        
        System.out.print("Ingrese " + N + " números enteros separados por espacios: ");
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }
        
        int[] result = new int[N];
        
        List<Integer> bits = new ArrayList<>();
        
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) != 0) {
                    bits.add(i);
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            result[i] = 0;
            for (int j = 31; j >= 0 && !bits.isEmpty(); j--) {
                if (bits.contains(j)) {
                    result[i] |= (1 << j);
                    bits.remove((Integer) j);
                }
            }
        }
        
        System.out.print("Resultado: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        scanner.close();
    }
}