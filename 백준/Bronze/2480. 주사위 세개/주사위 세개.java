import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int count = 0;
        int check = 0;
        int sum = 0;

        br.close();

        if (B == A) {
            count += 1;
            check = 1;
        }
        if (C == A) {
            count += 1;
            check = 1;
        }
        if (B == C) {
            count += 1;
            check = 2;
        }

        if (count == 3) {
            sum = 10000 + A * 1000;
        }
        if (count == 1) {
            if (check == 1) {
                sum = 1000 + A * 100;
            }
            if (check == 2) {
                sum = 1000 + B * 100;
            }
        }
        else {
            if (A > B && A > C) {
                sum = A * 100;
            }
            if (B > A && B > C) {
                sum = B * 100;
            }
            if (C > A && C > B) {
                sum = C * 100;
            }
        }
        System.out.println(sum);
    }
}