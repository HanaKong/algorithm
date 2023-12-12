import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int D = scanner.nextInt();
        int E = scanner.nextInt();
        int F = scanner.nextInt();

        scanner.close();

        for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999; y++) {
                if (A * x + B * y == C) {
                    if (D * x + E * y == F) {
                        System.out.println(x);
                        System.out.println(y);
                        break;
                    }
                }
            }
        }
    }
}