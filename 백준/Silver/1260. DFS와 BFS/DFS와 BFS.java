import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	final static int MAX = 1000 + 10;
	static int N, M, V;
	static boolean[][] graph;
	static boolean[] visited;
	static ArrayList<Integer> queue;
	
	public static void DFS(int idx) {
		visited[idx] = true;
		System.out.print(idx + " ");
		
		for (int i = 1; i <= N; i++) {
			if (visited[i] == false && graph[idx][i]) {
				DFS(i);
			}
		}
	}
	
	public static void BFS() {
		queue = new ArrayList<>();
		visited = new boolean[MAX];
		
		queue.add(V);
		visited[V] = true;
		
		while(!queue.isEmpty()) {
			int idx = queue.remove(0);
			System.out.print(idx + " ");
			
			for (int i = 1; i <= N; i++) {
				if (visited[i] == false && graph[idx][i] == true) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		graph = new boolean[MAX][MAX];
		visited = new boolean[MAX];
		
		for (int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A][B] = true;
			graph[B][A] = true;
		}
		
		DFS(V);
		System.out.println();
		
		BFS();
	}
}
