import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine().toUpperCase();
        int[] arr = new int[26];

        br.close();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) >= 65 && S.charAt(i) <=90) {
                arr[S.charAt(i) - 65]++;
            }
        }

        int max = 0;
        char answer = '?';

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] > max) {
                max = arr[j];
                answer = (char) (j + 65);
            }
            else if (arr[j] == max) {
                answer = '?';
            }
        }
        System.out.println(answer);
    }
}