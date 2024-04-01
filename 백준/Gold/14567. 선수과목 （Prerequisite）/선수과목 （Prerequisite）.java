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
		StringBuilder sb = new StringBuilder();
		Queue<int[]> q = new ArrayDeque<>();
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] list = new ArrayList[N + 1];
		int[] arr = new int[N + 1];
		int[] res = new int[N + 1];
		
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
		int cnt = 1;
		for (int i = 1; i < N + 1; i++) {
			if (arr[i] == 0) {
				q.offer(new int[] {i, cnt});
			}
		}
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			res[tmp[0]] = tmp[1];
			
			for (int i = 0; i < list[tmp[0]].size(); i++) {
				arr[list[tmp[0]].get(i)]--;
				if (arr[list[tmp[0]].get(i)] == 0) {
					q.offer(new int[] {list[tmp[0]].get(i), tmp[1]+1});
				}
			}
		}
		for (int i = 1; i < N + 1; i++) {
			System.out.print(res[i] + " ");
		}
	}
}
