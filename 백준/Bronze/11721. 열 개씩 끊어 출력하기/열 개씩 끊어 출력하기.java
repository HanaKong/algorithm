import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        for (int i = 0; i < str.length()/10+1; i++) {
            String[] arr = new String[str.length()/10+1];
            if (i < str.length()/10) {
                arr[i] = str.substring(i*10,(i+1)*10);
            }
            else {
                arr[i] = str.substring(i*10,(i+1)*10-(10-str.length()%10));
            }
            System.out.println(arr[i]);
        }
    }
}