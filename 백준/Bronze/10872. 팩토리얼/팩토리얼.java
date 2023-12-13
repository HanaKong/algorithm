import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int sum = 1;
        
        for (int i = 1; i < N+1; i++) {
            sum = sum * i;
        }
        System.out.println(sum);
    }
}