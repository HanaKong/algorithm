import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] A = {1,1,2,2,2,8};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[6];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != A[i]) {
                arr[i] = A[i] - arr[i];
            }
            else {
                arr[i] = 0;
            }
            System.out.print(arr[i] + " ");
        }
    }
}
