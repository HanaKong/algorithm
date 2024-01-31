import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		double B = sc.nextInt();
		int V = sc.nextInt();
		
		System.out.println((int)Math.ceil((double)(V-A)/(A-B)) + 1);
	}
}
