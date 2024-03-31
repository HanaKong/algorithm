import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        long[] A = new long[N];
        long[] B = new long[M];
        
        long res = 0;
        
        A[0] = sc.nextInt();
        
        for (int i = 1; i < N; i++) {
            A[i] = A[i - 1] + sc.nextInt();
        }
        
        for (int i = 0; i < N; i++) {
            int memo = (int) (A[i] % M);
            if (memo == 0) res++;
            B[memo]++;
        }
        for (int i = 0; i < M; i++) {
            if (B[i] > 1) {
                res = res + (B[i] * (B[i] - 1) / 2);
            }
        }
        System.out.println(res);
    }
}
