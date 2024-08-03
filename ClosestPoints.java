import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Point {
    int index;
    int x;
    int y;
    int distance;

    Point(int index, int x, int y) {
        this.index = index;
        this.x = x;
        this.y = y;
        this.distance = Math.abs(x) + Math.abs(y);
    }
}

public class ClosestPoints {

    public static List<Point> kClosestPoints(int[] A, int[] B, int N, int K) {
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            points.add(new Point(i, A[i], B[i]));
        }

        // Sort points based on their distance to the origin, and then by their original index
        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.distance != p2.distance) {
                    return Integer.compare(p1.distance, p2.distance);
                } else {
                    return Integer.compare(p1.index, p2.index);
                }
            }
        });

        // Extract the first K points
        List<Point> result = points.subList(0, K);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt(); // Number of test cases

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt(); // Number of points
            int[] A = new int[N];
            int[] B = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = scanner.nextInt();
            }

            for (int i = 0; i < N; i++) {
                B[i] = scanner.nextInt();
            }

            int K = scanner.nextInt(); // Number of closest points to find

            List<Point> result = kClosestPoints(A, B, N, K);

            for (Point p : result) {
                System.out.println(p.x + " " + p.y);
            }
        }

        scanner.close();
    }
}

