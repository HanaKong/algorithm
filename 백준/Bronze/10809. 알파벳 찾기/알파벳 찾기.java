import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        br.close();

        int[] arr = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i) - 97;
        }

        int[] answer = new int[26];

        Arrays.fill(answer, -1);

        for (int j = 0; j < arr.length; j++) {
            if (answer[arr[j]] == -1) {
                answer[arr[j]] = j;
            }
            else {
                continue;
            }
        }

        for (int k : answer) {
            System.out.print(k + " ");
        }
    }
}