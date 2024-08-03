import java.util.*;
class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        
        int[] A = new int[N + 1];
        int[] B = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            A[i] = scanner.nextInt();
        }
        
        for (int i = 1; i <= N; i++) {
            B[i] = scanner.nextInt();
        }
        
        long result = minCost(N, A, B);
        System.out.println(result);
    }
    
    public static long minCost(int N, int[] A, int[] B) {
        long[] dp = new long[N + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        
        dp[N] = 0;  // Start at index N with no cost
        
        for (int i = N; i > 1; i--) {
            // Try all possible jumps from i to j
            for (int j = i - 1; j >= 1; j--) {
                long costA = dp[i] + A[j];  // Cost of jumping in A
                long costB = dp[i] + B[j];  // Cost of jumping in B
                
                for (int k = i - 1; k > j; k--) {
                    costA += B[k];  // Add cost of passing through B
                    costB += A[k];  // Add cost of passing through A
                }
                
                dp[j] = Math.min(dp[j], Math.min(costA, costB));
            }
        }
        
        return dp[1];
    }
}
