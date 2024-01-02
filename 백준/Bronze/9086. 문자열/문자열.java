import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            String[] strArr = str.split("");
            if(strArr.length != 1) {
                System.out.println(strArr[0]+strArr[strArr.length-1]);
            }
            else {
                System.out.println(strArr[0]+strArr[0]);
            }
        }
    }
}