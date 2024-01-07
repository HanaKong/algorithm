import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int C = change(A);
        int D = change(B);

        System.out.println(Math.max(C, D));
    }
    public static int change(int num) {
        int X = num / 100;
        int Y = num % 100;
        int Z = Y % 10;
        return Z * 100 + (Y - Z) + X;
    }
}