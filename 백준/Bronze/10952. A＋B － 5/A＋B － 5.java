import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNextInt()) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int C = A + B;
            
            if (A != 0 && B != 0) {
                System.out.println(C);    
            }
            else {
                break;
            }
        }
        scanner.close();
    }
}