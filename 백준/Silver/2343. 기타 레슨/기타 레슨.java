import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		int st = 0, end = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			if (st < arr[i]) st = arr[i];
			end += arr[i];
		}
		while (st <= end) {
			int mid = (st + end) / 2;
			int sum = 0, cnt = 0;
			for (int i = 0; i < N; i++) {
				if (sum + arr[i] > mid) {
					cnt++;
					sum = 0;
				}
				sum += arr[i];
			}
			if (sum != 0) {
				cnt++;
			}
			if (cnt > M) st = mid + 1;
			else end = mid - 1;
		}
		System.out.println(st);
	}
}
