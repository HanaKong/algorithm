import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int add = Integer.parseInt(br.readLine());
        
        if (M + add > 60) {
            H = H + (M + add) / 60;
            M = (M + add) - (60 * ((M + add) / 60));
            if (H >= 24) {
                H = H - 24;
            }
            System.out.println(H + " " + M);
        }
        else if (M + add == 60) {
            if (H + 1 >= 24) {
                H = H - 24;
            }
            System.out.println(H + 1 + " " + 0);
        }
        else {
            System.out.println(H + " " + (M + add));
        }
    }
}