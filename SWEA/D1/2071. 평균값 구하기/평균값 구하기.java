import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int sum = 0;

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++) {
                sum += Integer.parseInt(st.nextToken());
            }
            int A = sum / 10;
            double B = sum / 10.0;

            if (B-A >= 0.5) {
                A += 1;
            }
            System.out.println("#" + i + " " + A);
            sum = 0;
        }
    }
}