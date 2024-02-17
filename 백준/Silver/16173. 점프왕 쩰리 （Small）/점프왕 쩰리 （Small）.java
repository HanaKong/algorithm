import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] dirY = {1, 0};
	static int[] dirX = {0, 1};
	static int[][] graph;
	static int N;
	
	public static void dfs(int y, int x) {
		int temp = graph[y][x];
		graph[y][x] = 0;
		
		if(y == N && x == N) {
			return;
		}
		
		for (int i = 0; i < 2; i++) {
			int newY = y + dirY[i] * temp;
			int newX = x + dirX[i] * temp;
			if (temp == 0 || newY >= N+2 || newX >= N+2) {
				continue;
			}
			dfs(newY, newX);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		graph = new int[N+2][N+2];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(1, 1);
		
		if (graph[N][N] == 0) bw.write("HaruHaru");
		else bw.write("Hing");
		
		bw.close();
		br.close();
	}
}
