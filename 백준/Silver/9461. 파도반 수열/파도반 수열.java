import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			long[] d = new long[N+1];
			for (int i = 1; i < N + 1; i++) {
				if (i < 4) {
					d[i] = 1;
				}
				else {
					d[i] = -1;
				}
			}
			for (int i = 4; i <= N; i++) {
				d[i] = d[i - 2] + d[i - 3];
			}
			System.out.println(d[N]);
		}
	}
}
