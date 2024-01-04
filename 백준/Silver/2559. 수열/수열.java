import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[] prefix = new int[N+1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            prefix[i] = prefix[i-1] + Integer.parseInt(st.nextToken());
        }
        int max = -100000000;
        for (int i = R; i <= N; i++) {
            int temp = prefix[i] - prefix[i-R];
            if (temp > max) {
                max = temp;
            }
        }
        System.out.println(max);
    }
}