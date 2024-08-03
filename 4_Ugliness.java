import java.util.*;

 class MinimizeUgliness {

    // Function to calculate the decimal value of the binary string
    public static long calculateUgliness(char[] str) {
        long value = 0;
        for (char c : str) {
            value = value * 2 + (c - '0');
        }
        return value;
    }

    // Function to minimize the ugliness of the binary string
    public static long minimizeUgliness(int N, String S, int CASH, int A, int B) {
        // Convert the string to a character array for easier manipulation
        char[] binaryString = S.toCharArray();

        // Minimize ugliness by flipping the most significant '1's to '0's if it is cheaper or equal
        for (int i = 0; i < N && CASH >= B; i++) {
            if (binaryString[i] == '1') {
                binaryString[i] = '0';
                CASH -= B;
            }
        }

        // Further minimize by swapping if we still have coins left
        for (int i = 0; i < N - 1 && CASH >= A; i++) {
            if (binaryString[i] == '1') {
                // Find the rightmost '0' to swap with
                int j = N - 1;
                while (j > i && binaryString[j] != '0') {
                    j--;
                }
                if (j > i) {
                    // Perform the swap
                    char temp = binaryString[i];
                    binaryString[i] = binaryString[j];
                    binaryString[j] = temp;
                    CASH -= A;
                }
            }
        }

        // Calculate the final ugliness
        long finalUgliness = calculateUgliness(binaryString);

        // Return the result modulo 10^9 + 7
        return finalUgliness % 1000000007;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User input
        System.out.print("Enter the number of characters (N): ");
        int N = scanner.nextInt();
        System.out.print("Enter the binary string (S): ");
        String S = scanner.next();
        System.out.print("Enter the total number of coins (CASH): ");
        int CASH = scanner.nextInt();
        System.out.print("Enter the cost to swap two characters (A): ");
        int A = scanner.nextInt();
        System.out.print("Enter the cost to flip a character (B): ");
        int B = scanner.nextInt();

        // Output the result
        System.out.println("Output: " + minimizeUgliness(N, S, CASH, A, B));
    }
}

