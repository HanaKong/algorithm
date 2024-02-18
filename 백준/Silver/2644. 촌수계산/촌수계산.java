import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int N, A, B, M, res;
	static boolean[][] graph;
	static boolean[] visited;
	
	public static void dfs(int idx, int cnt) {
		visited[idx] = true;
		if (idx == B) {
			res = cnt;
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && graph[idx][i]) {
				dfs(i, cnt+1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken()); 
		B = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		
		graph = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		res = -1;
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph[x][y] = true;
			graph[y][x] = true;
		}
		
		dfs(A, 0);
				
		bw.write(String.valueOf(res));
		
		bw.close();
		br.close();
	}
}
