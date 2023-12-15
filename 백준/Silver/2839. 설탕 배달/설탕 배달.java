import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        br.close();

        int A = 0;
        int B = 0;

        for (int X = 0; X < N; X++) {
            for (int Y = 0; Y < N; Y++) {
                if (5 * X + 3 * Y == N) {
                    A = X;
                    B = Y;
                }
            }
        }
        if (A+B != 0) {
            System.out.println(A + B);
        }
        else {
            System.out.println(-1);
        }
    }
}