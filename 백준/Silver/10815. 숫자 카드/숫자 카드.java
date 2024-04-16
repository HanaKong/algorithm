import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int M = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
			int num = sc.nextInt();
			sb.append(BS(arr, num)).append(" ");
		}
		System.out.println(sb);
	}

	private static int BS(int[] arr, int target) {
		int lo = 0;
		int hi = arr.length;
		
		while (lo < hi) {
			int mid = (lo + hi) / 2; 
			if (arr[mid] < target) {
				lo = mid + 1;
			}
			else if (arr[mid] > target) {
				hi = mid;
			}
			else {
				return 1;
			}
		}
		return 0;
	}
}
