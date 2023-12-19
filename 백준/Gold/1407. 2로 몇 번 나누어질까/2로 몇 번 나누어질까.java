import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        br.close();

        long sumB = 0;

        A -= 1;
        long sumA = 0;

        sumB += B;
        sumA += A;

        for (long i = 2; i <= B; i *= 2) {
            sumB += (B/i)*(i/2);
        }
        for (long i = 2; i <= A; i *= 2) {
            sumA += (A/i)*(i/2);
        }
        System.out.println(sumB-sumA);
    }
}