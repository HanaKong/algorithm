import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String st = br.readLine();
        String[] arr = st.split("");
        int sum = 0;

        for (String s : arr) {
            if (s.equals("A") || s.equals("B") || s.equals("C")) {
                sum += 3;
            } else if (s.equals("D") || s.equals("E") || s.equals("F")) {
                sum += 4;
            } else if (s.equals("G") || s.equals("H") || s.equals("I")) {
                sum += 5;
            } else if (s.equals("J") || s.equals("K") || s.equals("L")) {
                sum += 6;
            } else if (s.equals("M") || s.equals("N") || s.equals("O")) {
                sum += 7;
            } else if (s.equals("P") || s.equals("Q") || s.equals("R") || s.equals("S")) {
                sum += 8;
            } else if (s.equals("T") || s.equals("U") || s.equals("V")) {
                sum += 9;
            } else {
                sum += 10;
            }
        }
        System.out.println(sum);
    }
}