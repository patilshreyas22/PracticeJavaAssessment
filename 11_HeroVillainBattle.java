import java.util.*;

public class HeroVillainBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt(); // Number of villains
        int M = scanner.nextInt(); // Number of heroes
        int H = scanner.nextInt(); // Health of each hero
        
        int[] villainHealth = new int[N];
        for (int i = 0; i < N; i++) {
            villainHealth[i] = scanner.nextInt();
        }
        
        System.out.println(calculateMinVillainsToRemove(N, M, H, villainHealth));
        
        scanner.close();
    }
    
    public static int calculateMinVillainsToRemove(int N, int M, int H, int[] villainHealth) {
        long totalHeroHealth = (long) M * H;
        int villainsToRemove = 0;
        
        for (int i = 0; i < N; i++) {
            if (totalHeroHealth <= 0) {
                return villainsToRemove;
            }
            
            if (H > villainHealth[i]) {
                totalHeroHealth -= villainHealth[i];
            } else if (H < villainHealth[i]) {
                totalHeroHealth -= H;
                M--;
            }
            // If H == villainHealth[i], both are defeated, so we just continue
            
            if (M == 0 && i < N - 1) {
                villainsToRemove = i + 1;
            }
        }
        
        return villainsToRemove;
    }
}
