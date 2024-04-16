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
			int num = Integer.parseInt(st.nextToken());
            // getOrDefault = 값이 있을 때 없을 때 조건 추가
			nums.put(num, nums.getOrDefault(num, 0) + 1);
		}
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			int res = Integer.parseInt(st.nextToken());
			sb.append(nums.getOrDefault(res, 0)).append(" ");
		}
		
		System.out.println(sb);
		
		br.close();
	}
}
