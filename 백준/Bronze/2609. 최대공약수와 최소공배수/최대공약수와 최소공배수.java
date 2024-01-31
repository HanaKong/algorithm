import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = 1;
		for (int i = A+B; i > 1; i--) {
			if (A % i == 0 && B % i == 0) {
				A /= i;
				B /= i;
				C *= i;
			}
		}
		System.out.println(C);
		System.out.println(A * B * C); 
	}
}
