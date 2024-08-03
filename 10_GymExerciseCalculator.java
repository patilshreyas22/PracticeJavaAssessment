import java.util.*;

public class GymExerciseCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int E = scanner.nextInt();
        int N = scanner.nextInt();
        
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        
        System.out.println(calculateMinExercises(E, N, A));
        
        scanner.close();
    }
    
    public static int calculateMinExercises(int E, int N, int[] A) {
        Arrays.sort(A);
        int totalEnergy = 0;
        int exerciseCount = 0;
        
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                if (totalEnergy >= E) {
                    return exerciseCount;
                }
                totalEnergy += A[i];
                exerciseCount++;
            }
        }
        
        return (totalEnergy >= E) ? exerciseCount : -1;
    }
}
