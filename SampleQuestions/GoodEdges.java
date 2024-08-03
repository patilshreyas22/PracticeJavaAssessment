import java.util.*;

public class GoodEdges {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int[] A = new int[N];
        int[] P = new int[N];
        
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        
        for (int i = 0; i < N; i++) {
            P[i] = scanner.nextInt();
        }
        
        System.out.println(countGoodEdges(N, A, P));
        
        scanner.close();
    }
    
    public static int countGoodEdges(int N, int[] A, int[] P) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 1; i < N; i++) {
            tree.get(P[i] - 1).add(i);
        }
        
        int goodEdges = 0;
        for (int i = 1; i < N; i++) {
            if (isGoodEdge(i, -1, tree, A)) {
                goodEdges++;
            }
        }
        
        return goodEdges;
    }
    
    private static boolean isGoodEdge(int node, int parent, List<List<Integer>> tree, int[] A) {
        Set<Integer> values = new HashSet<>();
        return dfs(node, parent, tree, A, values) && values.size() == tree.size();
    }
    
    private static boolean dfs(int node, int parent, List<List<Integer>> tree, int[] A, Set<Integer> values) {
        if (values.contains(A[node])) {
            return false;
        }
        values.add(A[node]);
        for (int child : tree.get(node)) {
            if (child != parent) {
                if (!dfs(child, node, tree, A, values)) {
                    return false;
                }
            }
        }
        return true;
    }
}
