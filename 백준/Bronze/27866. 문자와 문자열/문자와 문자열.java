import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String text = scanner.next();
        int number = scanner.nextInt();
        
        String anwser = text.substring(number-1,number);
        System.out.println(anwser);
        
        scanner.close();
    }
}
