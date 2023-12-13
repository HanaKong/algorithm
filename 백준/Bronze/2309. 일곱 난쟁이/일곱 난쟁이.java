import java.util.Scanner;
import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[9];
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }
        scanner.close();

        for (int j = 0; j < arr.length - 1; j++) {
            for (int k = j+1; k < arr.length; k++) {
                if (sum - arr[j] - arr[k] == 100) {
                    arr[j] = 0;
                    arr[k] = 0;
                    Arrays.sort(arr);
                    for (int l = 2; l < arr.length; l++) {
                        System.out.println(arr[l]);
                    }
                    return;
                }
            }
        }
    }
}