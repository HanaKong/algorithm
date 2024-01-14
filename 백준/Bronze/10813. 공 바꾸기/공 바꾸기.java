import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = (i+1);
        }

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int A = sc.nextInt() - 1;
            int B = sc.nextInt() - 1;
            int temp = 0;

            temp = arr[A];
            arr[A] = arr[B];
            arr[B] = temp;
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}