import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new ArrayDeque<>();
		List<Integer>[] list = new ArrayList[N+1];
		int[] arr = new int[N + 1];
		
		for (int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}
	
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			int[] tmp = new int[T];
			for (int j = 0; j < T; j++) {
				tmp[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < T-1; j++) {
				list[tmp[j]].add(tmp[j+1]);
				arr[tmp[j+1]]++;
			}
		}
		
		for (int i = 1; i < N + 1; i++) {
			if (arr[i] == 0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int v = q.poll();
			sb.append(v).append("\n");
			
			for (int i = 0; i < list[v].size(); i++) {
				arr[list[v].get(i)]--;
				if (arr[list[v].get(i)] == 0) {
					q.offer(list[v].get(i));
				}
			}
		}
		boolean chk = true;
		for (int i = 0; i < N+1; i++) {
			if (arr[i] != 0) {
				chk = false;
				break;
			}
		}
		if (chk) {
			System.out.println(sb);
		}
		else {
			System.out.println(0);
		}
	}
}
 