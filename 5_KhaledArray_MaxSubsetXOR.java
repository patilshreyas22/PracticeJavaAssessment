import java.util.Scanner;

 class MaxSubsetXOR {

    // Function to find the maximum XOR subset
    public static int findMaxSubsetXOR(int[] arr, int N) {
        int maxSubsetSize = N / 2;
        int maxXOR = 0;

        // Iterate over all subsets
        for (int i = 0; i < (1 << N); i++) {
            int count = Integer.bitCount(i);
            if (count > maxSubsetSize) {
                continue;
            }

            int currentXOR = 0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) > 0) {
                    currentXOR ^= arr[j];
                }
            }

            maxXOR = Math.max(maxXOR, currentXOR);
        }

        return maxXOR;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Enter the number of elements (N): ");
        int N = scanner.nextInt();
        int[] A = new int[N];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        // Find and print the maximum XOR of a subset of at most N/2 elements
        int result = findMaxSubsetXOR(A, N);
        System.out.println("Maximum XOR of a subset of at most N/2 elements: " + result);
    }
}

