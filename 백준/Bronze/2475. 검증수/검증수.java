import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int arr[] = new int[6];
        double arrDouble[] = new double[5];
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            arr[i] = scanner.nextInt();
            arrDouble[i] = Math.pow(arr[i], 2);
            sum += (int) arrDouble[i];
        }
        System.out.println(sum % 10);
        
        scanner.close();
    }
}