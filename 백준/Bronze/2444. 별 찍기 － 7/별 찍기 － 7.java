import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        br.close();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N-i-1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2*(i+1)-1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int l = 0; l < N-1; l++) {
            for (int m = 0; m < l+1; m++) {
                System.out.print(" ");
            }
            for (int n = 2*l; n < 2*(N-1)-1; n++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}