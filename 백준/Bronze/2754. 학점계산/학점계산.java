import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        br.close();

        String[] arr = str.split("");

        double grade = 0;

        if (arr[0].equals("A")) grade = 4;
        else if (arr[0].equals("B")) grade = 3;
        else if (arr[0].equals("C")) grade = 2;
        else if (arr[0].equals("D")) grade = 1;
        else grade = 0;

        if (arr.length > 1) {
            if (arr[1].equals("+")) grade = grade + 0.3;
            else if (arr[1].equals("-")) grade = grade - 0.3;
        }

        System.out.println(grade);
    }
}