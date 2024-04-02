import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Queue<int[]> q = new ArrayDeque<>();
		
		int N = Integer.parseInt(br.readLine());
		// 시간
		int[] cost = new int[N+1];
		// 진입차수
		int[] arr = new int[N+1];
		
		// 해당 번호 건물 걸리는 시간
		int[] res = new int[N+1];
		int[] temp = new int[N+1];
		
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
				q.offer(new int[] {i, cost[i]});
				temp[i] = cost[i];
			}
		}
		
		while(!q.isEmpty()) {
			int[] d = q.poll();
			
			int num = d[0];
			int time = d[1];
			
			res[num] = time;
			
			for(int i = 0; i < list[num].size(); i++) {
				arr[list[num].get(i)]--;
				
				
				// 다음 지점
				temp[list[num].get(i)] = Math.max(temp[num]+cost[list[num].get(i)], temp[list[num].get(i)]);
				
//				System.out.println(num+" "+list[num].get(i));
//				System.out.println(Arrays.toString(temp));

				if (arr[list[num].get(i)] == 0) {
					q.offer(new int[] {list[num].get(i), time + cost[list[num].get(i)]});
				}
			}
		}
//		for (int i = 1; i < N + 1; i++) {
//			temp[i] += cost[i];
//			if (res[i] < temp[i]) res[i] = temp[i];
//		}
		for (int i = 1; i < N + 1; i++) {
			System.out.println(temp[i]);
		}
	}
}
