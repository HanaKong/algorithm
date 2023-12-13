import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int number1 = scanner.nextInt();
        String number2 = scanner.next();
        
        scanner.close();
        
        String[] number2Arr = number2.split("");
        int sum = 0;
        
        for (int i = 0; i < number1; i++) {
            sum += Integer.parseInt(number2Arr[i]);
        }
        System.out.println(sum);
    }
}