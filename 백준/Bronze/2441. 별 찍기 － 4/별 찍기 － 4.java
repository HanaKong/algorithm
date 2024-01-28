import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[][] arr = new String[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                arr[i][j] = "*";
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == null) {
                    System.out.print(" ");
                }
                else {
                    System.out.print(arr[i][j]);
                }
            }
            System.out.println();
        }
    }
}