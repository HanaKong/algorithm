import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		String str = sc.next().replaceAll("A", "").replaceAll("J", "").replaceAll("V", "");
		
		if(str.length() == 0) {
			System.out.println("nojava");
		}
		else {
			System.out.println(str);
		}
		
	}
}
