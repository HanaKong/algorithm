import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		System.out.println(factorial(A)/(factorial(A-B) * factorial(B)));
	}
	public static int factorial(int n) {
		if (n <= 0) {
			return 1;
		}
		return n * factorial(n-1);
	}
}
