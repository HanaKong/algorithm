import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        br.close();

        List<String> ls = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            while (N % i == 0) {
                ls.add(Integer.toString(i));
                N = N / i;
            }
        }
        for (String l : ls) {
            System.out.println(l);
        }
    }
}