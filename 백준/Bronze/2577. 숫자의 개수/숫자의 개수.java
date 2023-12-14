import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        br.close();

        int D = A * B * C;

        String str = String.valueOf(D);

        int[] arr= new int[10];

        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 48] ++;
        }
        for (int j : arr) {
            System.out.println(j);
        }
    }
}