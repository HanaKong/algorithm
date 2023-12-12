import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {

            long number = scanner.nextLong();

            int A = 0;

            for (int j = 2; j < 1000001; j++) {
                if (number % j == 0) {
                    A = 1;
                    break;
                }
            }
            if (A == 1) System.out.println("NO");
            else System.out.println("YES");
        }
        scanner.close();
    }
}