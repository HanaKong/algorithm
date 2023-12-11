import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int H = scanner.nextInt(); //높이
            int W = scanner.nextInt(); //넓이
            int N = scanner.nextInt(); // n번째 손님

            if (N % H == 0) System.out.println((H * 100) + (N / H));
            else System.out.println(((N % H) * 100) + (N / H + 1));
        }
        scanner.close();
    }
}