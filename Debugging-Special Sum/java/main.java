import java.util.*;

public class SpecialSumCalculator {

    public static long specialSum(int N, int M, int[] A, int[] B, int[] K) {
        long specialSum = 0;

        for (int i = 0; i < N; i++) {
            long maxProduct = Long.MIN_VALUE;

            int left = Math.max(1, i + 1 - K[i]); // 1-based indexing
            int right = Math.min(M, i + 1 + K[i]);

            for (int j = left; j <= right; j++) {
                maxProduct = Math.max(maxProduct, 1L * A[i] * B[j - 1]); // Convert j to 0-based
            }

            specialSum += maxProduct;
        }

        return specialSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] A = new int[N];
            int[] B = new int[M];
            int[] K = new int[N];

            for (int i = 0; i < N; i++) A[i] = sc.nextInt();
            for (int i = 0; i < M; i++) B[i] = sc.nextInt();
            for (int i = 0; i < N; i++) K[i] = sc.nextInt();

            System.out.println(specialSum(N, M, A, B, K));
        }

        sc.close();
    }
}
