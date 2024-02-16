import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int cnt = 0;
		for (int i = 5; i < 500; i *= 5) {
			cnt += N / i;
		}
		System.out.println(cnt);
	}
}
