import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[10];

        for (int i = 0; i < 10; i++) {
            arr[i] = (Integer.parseInt(br.readLine()) % 42);
        }

        br.close();

        arr = Arrays.stream(arr).distinct().toArray();

        System.out.println(arr.length);
    }
}