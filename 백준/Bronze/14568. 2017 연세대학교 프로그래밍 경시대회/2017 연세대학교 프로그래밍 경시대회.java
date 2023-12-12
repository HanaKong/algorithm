import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int candyNumber = scanner.nextInt();
        int anwser = 0;

        for (int A = 1; A <= candyNumber; A++) {
            for (int B = 1; B <= candyNumber; B++) {
                for (int C = 1; C <= candyNumber; C++) {
                    if (candyNumber == A + B + C) {
                        if (A >= B + 2) {
                            if (A != 0 && B != 0 && C != 0) {
                                if (C % 2 == 0) {
                                    anwser += 1;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(anwser);

        scanner.close();
    }
}