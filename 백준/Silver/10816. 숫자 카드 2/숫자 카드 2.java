import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		Map<Integer, Integer> nums = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			int tmp = 0;
			int num = sc.nextInt();
			if (nums.get(num) != null) {
				tmp = nums.get(num);
			}
			nums.put(num, tmp + 1);
		}
		int M = sc.nextInt();
		
		for (int i = 0; i < M; i++) {
			int res = sc.nextInt();
			if (nums.get(res) != null) {
				sb.append(nums.get(res)).append(" ");
			}
			else {
				sb.append(0).append(" ");
			}
		}
		
		System.out.println(sb);
		
		sc.close();
	}
}
