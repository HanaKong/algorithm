import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt() - 1;
            int B = sc.nextInt();
            int C = sc.nextInt();

            for (int j = A; j < B; j++) {
                arr[j] = C;
            }
        }
        for (int s : arr) {
            System.out.print(s + " ");
        }
    }
}