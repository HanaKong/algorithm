import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int changeToAsc = scanner.next().charAt(0);
        System.out.println(changeToAsc);
        
        scanner.close();
    }
}