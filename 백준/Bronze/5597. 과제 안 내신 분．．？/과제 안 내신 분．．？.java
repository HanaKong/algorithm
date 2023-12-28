import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[31];
        for (int i = 1; i < 29; i++) {
            int number = Integer.parseInt(br.readLine());
            arr[number] = 1;
        }

        br.close();

        for (int j = 1; j < 31; j++) {
            if (arr[j] != 1) {
                System.out.println(j);
            }
        }
    }
}