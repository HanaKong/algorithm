import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Map<Integer, Integer> nums = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int tmp = 0;
			int num = Integer.parseInt(st.nextToken());
			if (nums.get(num) != null) {
				tmp = nums.get(num);
			}
			nums.put(num, tmp + 1);
		}
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			int res = Integer.parseInt(st.nextToken());
			if (nums.get(res) != null) {
				sb.append(nums.get(res)).append(" ");
			}
			else {
				sb.append(0).append(" ");
			}
		}
		
		System.out.println(sb);
		
		br.close();
	}
}
