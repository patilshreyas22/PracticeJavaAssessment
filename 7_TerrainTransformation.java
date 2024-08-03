import java.util.Scanner;

public class TerrainTransformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of elements in L
        int n = scanner.nextInt();
        
        // Read the sea levels into an array
        int[] L = new int[n];
        for (int i = 0; i < n; i++) {
            L[i] = scanner.nextInt();
        }
        
        // Close the scanner as we no longer need it
        scanner.close();
        
        // Calculate the minimum number of days needed
        int days = 0;
        
        for (int i = 1; i < n; i++) {
            if (L[i] >= L[i-1]) {
                int difference = L[i] - L[i-1] + 1;
                int D = 1;
                while ((2 * D - 1) < difference) {
                    D++;
                }
                days += D;
                L[i] -= difference;
            }
        }
        
        // Print the result
        System.out.println(days);
    }
}

