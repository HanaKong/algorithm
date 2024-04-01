import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] list = new ArrayList[N + 1];
		int[] arr = new int[N + 1];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list[A].add(B);
			arr[B]++;
		}
		
		for (int i = 1; i < N+1; i++) {
			if (arr[i] == 0) {
				pq.offer(i);
			}
		}
		
		while(!pq.isEmpty()) {
			int tmp = pq.poll();
			sb.append(tmp + " ");
			for (int i = 0; i < list[tmp].size(); i++) {
				arr[list[tmp].get(i)]--;
				if (arr[list[tmp].get(i)] == 0) {
					pq.offer(list[tmp].get(i));
				}
			}
		}
		System.out.println(sb);
	}
}
