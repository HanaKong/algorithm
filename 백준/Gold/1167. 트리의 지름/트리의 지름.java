import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] distance;
	static ArrayList<Edge>[] list;
	static boolean[] visited;
	static Queue<Integer> q = new ArrayDeque<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Edge>();
		}
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int S = Integer.parseInt(st.nextToken());
			while (true) { 
				int E = Integer.parseInt(st.nextToken());
				if (E == -1) break;
				int V = Integer.parseInt(st.nextToken());
				list[S].add(new Edge(E, V));
			}
		}
		
		distance = new int[N + 1];
		visited = new boolean[N + 1];
		
		BFS(1);
		
		int max = 1;
		
		for (int i = 2; i <= N; i++) {
			if (distance[max] < distance[i]) {
				max = i;
			}
		}
		
		distance = new int[N + 1];
		visited = new boolean[N + 1];
		
		BFS(max);
		
		Arrays.sort(distance);
		bw.write(String.valueOf(distance[N]));
		
		bw.close();
		br.close();
	}
	
	private static void BFS(int idx) {
		q.offer(idx);
		visited[idx] = true;
		while (!q.isEmpty()) {
			int now_node = q.poll();
			for (Edge i : list[now_node]) {
				int e = i.e;
				int v = i.v;
				if (!visited[e]) {
					visited[e] = true;
					q.offer(e);
					distance[e] = distance[now_node] + v;
				}
			}
		}
	}

	private static class Edge {
		int e;
		int v;
		
		public Edge(int e, int v) {
			this.e = e;
			this.v = v;
		}
	}
}
