import java.util.Scanner;

class Main {
    public static int mountain(int[] arr, int n) {
        int count = 0;
        
        int m1 = n / 2 - 1;
        int m2 = (n % 2 == 0) ? m1 + 1 : m1 + 2;
        
        // Make the left side a descending sequence
        for (int i = m1 - 1; i >= 0; i--) {
            if (arr[i] != arr[i + 1] - 1) {
                count++;
                arr[i] = arr[i + 1] - 1;
            }
        }
        
        // Make the right side a descending sequence
        for (int i = m2; i < n; i++) {
            if (arr[i] != arr[i - 1] - 1) {
                count++;
                arr[i] = arr[i - 1] - 1;
            }
        }
        
        // Ensure the middle elements are equal
        if (arr[m1] != arr[m2]) {
            count++;
            arr[m2] = arr[m1];
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        System.out.println(mountain(arr, n));
    }
}

