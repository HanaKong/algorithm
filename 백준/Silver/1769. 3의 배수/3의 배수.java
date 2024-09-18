import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String number = br.readLine();

        int count = 0;

        while (true) {
            long sum = 0;
            if (number.length() == 1) break;
            for (int i = 0; i < number.length(); i++) {
                sum += number.charAt(i) - '0';
            }
            count++;
            number = String.valueOf(sum);
        }
        if(Integer.parseInt(number) % 3 == 0) {
            System.out.println(count + System.lineSeparator() + "YES");
        }
        else {
            System.out.println(count + System.lineSeparator() + "NO");
        }
        br.close();
    }
}
