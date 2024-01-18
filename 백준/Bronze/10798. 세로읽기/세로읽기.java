import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] arr = new String[5][15];

        for (int i = 0; i < arr.length; i++) {
            String[] temp = sc.next().split("");
            for (int j = 0; j < temp.length; j++) {
                arr[i][j] = temp[j];
            }
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j][i] != null) {
                    System.out.print(arr[j][i]);
                }
            }
        }
    }
}