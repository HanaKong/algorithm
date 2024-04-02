import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Queue<Integer> q = new ArrayDeque<>();
		
		int N = Integer.parseInt(br.readLine());
		int[] cost = new int[N+1];
		int[] arr = new int[N+1];
		int[] res = new int[N+1];
		
		List<Integer>[] list = new ArrayList[N + 1];
		
		for(int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			cost[i] = Integer.parseInt(st.nextToken());
			while(st.hasMoreElements()) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == -1) continue;
				list[tmp].add(i);
				arr[i]++;
			}
		}
		
		for(int i = 1; i < N + 1; i++) {
			if (arr[i] == 0) {
				q.offer(i);
				res[i] = cost[i];
			}
		}
		
		while(!q.isEmpty()) {
			int d = q.poll();
			
			for(int i = 0; i < list[d].size(); i++) {
				arr[list[d].get(i)]--;
				
				res[list[d].get(i)] = Math.max(res[d]+cost[list[d].get(i)], res[list[d].get(i)]);

				if (arr[list[d].get(i)] == 0) {
					q.offer(list[d].get(i));
				}
			}
		}

		for (int i = 1; i < N + 1; i++) {
			System.out.println(res[i]);
		}
	}
}