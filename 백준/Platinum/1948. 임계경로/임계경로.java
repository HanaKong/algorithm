import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		ArrayList<int[]>[] route = new ArrayList[N + 1];
		ArrayList<int[]>[] reverseRoute = new ArrayList[N + 1];
		
		for (int i = 0; i <= N; i++) {
			route[i] = new ArrayList<>();
			reverseRoute[i] = new ArrayList<>();
		}
		
		int[] inDegree = new int[N + 1];
		int[] res = new int[N + 1];
		
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken()); 
			int B = Integer.parseInt(st.nextToken()); 
			int C = Integer.parseInt(st.nextToken());
			route[A].add(new int[] {B, C});
			reverseRoute[B].add(new int[] {A, C});
			inDegree[B]++;
		}
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(start);
		
		while (!q.isEmpty()) {
			int now = q.poll();
			
			for (int[] next : route[now]) {
				inDegree[next[0]]--;
				res[next[0]] = Math.max(res[next[0]], res[now] + next[1]);
				
				if (inDegree[next[0]] == 0) {
					q.offer(next[0]);
				}
			}
		}
		
		int cnt = 0;
		boolean[] visited = new boolean[N + 1];
		
		q.offer(end);
		
		visited[end] = true;
		
		while (!q.isEmpty()) { 
			int now = q.poll();
			for (int[] prev : reverseRoute[now]) {
				if (res[prev[0]] + prev[1] == res[now]) {
					cnt++;
					
					if (!visited[prev[0]]) {
						visited[prev[0]] = true;
						q.offer(prev[0]);
					}
				}
			}
		}
		
		bw.write(String.valueOf(res[end]));
		bw.newLine();
		bw.write(String.valueOf(cnt));
		
		bw.flush();
		bw.close();
		br.close();
	}
}
