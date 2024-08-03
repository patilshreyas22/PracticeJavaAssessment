import java.util.Scanner;

public class MaxEqualPieces {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the input string
        String s = scanner.nextLine();
        
        // Close the scanner as we no longer need it
        scanner.close();
        
        int n = s.length();
        int maxPieces = 1; // At least the string itself can be a piece
        
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                int pieceLength = n / i;
                boolean valid = true;
                
                String piece = s.substring(0, pieceLength);
                for (int j = 1; j < i; j++) {
                    if (!s.substring(j * pieceLength, (j + 1) * pieceLength).equals(piece)) {
                        valid = false;
                        break;
                    }
                }
                
                if (valid) {
                    maxPieces = i;
                }
            }
        }
        
        System.out.println(maxPieces);
    }
}

