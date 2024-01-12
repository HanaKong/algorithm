import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        int sum = 0;
        String str = "";
        int temp = 0;

        for (int i = 0; i < number; i++) {
            sum = 0;
            str = i + "";
            String[] arr = str.split("");
            for (int j = 0; j < str.length(); j++) {
                sum += Integer.parseInt(arr[j]);
            }
            sum += i;
            if (sum == number) {
                temp = i;
                break;
            }
        }
        System.out.println(temp);
    }
}