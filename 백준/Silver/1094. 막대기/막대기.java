import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int X = sc.nextInt();
		int count = 0;
        
        for (int i = 0; i < 7; i++) {
            if ((X & (1 << i)) > 0) count++;
        }
		System.out.println(count);
		
	}

}