import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            String[] str = s.split("X");

            int sum = 0;

            for (String string : str) {
                if (!string.isEmpty()) {
                    int A = string.length();
                    sum += (A * (A + 1)) / 2;
                }
            }
            System.out.println(sum);
        }
    }
}