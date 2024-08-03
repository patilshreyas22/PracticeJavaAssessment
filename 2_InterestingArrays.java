import java.util.Scanner;

public class InterestingArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Take inputs from the user
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        
        // Close the scanner as we no longer need it
        scanner.close();
        
        // Create a DP table to store the number of valid sequences
        int[][] dp = new int[k + 1][n + 1];
        
        // Initialize the first row of the DP table
        for (int i = 1; i <= n; i++) {
            dp[1][i] = 1;
        }
        
        // Fill the DP table
        for (int length = 2; length <= k; length++) {
            for (int last = 1; last <= n; last++) {
                for (int prev = 1; prev <= n; prev++) {
                    if (last % prev == 0) {
                        dp[length][last] = (dp[length][last] + dp[length - 1][prev]) % 10000;
                    }
                }
            }
        }
        
        // Calculate the result by summing up all valid sequences of length k
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = (result + dp[k][i]) % 10000;
        }
        
        // Print the result
        System.out.println(result);
    }
}

