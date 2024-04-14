import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		long st = 1, end = K, res = 0;
		
		while (st <= end) {
			long mid = (st + end) / 2;
			long cnt = 0;
			
			for (int i = 1; i <= N; i++) {
				cnt += Math.min(mid / i, N);
			}
			if (cnt < K) {
				st = mid + 1;
			}
			else {
				res = mid;
				end = mid - 1;
			}
		}
		System.out.println(res);
	}
}