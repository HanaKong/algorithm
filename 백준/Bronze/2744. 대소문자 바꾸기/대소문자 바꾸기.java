import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        
        br.close();
        
        String[] arr = str.split("");

        for (String s : arr) {
            char temp = 0;
            if (s.charAt(0) >= 65 && s.charAt(0) <= 90) {
                temp = (char) (s.charAt(0) + 32);
            } else if (s.charAt(0) >= 97 && s.charAt(0) <= 122) {
                temp = (char) (s.charAt(0) - 32);
            }
            System.out.print(temp);
        }
    }
}