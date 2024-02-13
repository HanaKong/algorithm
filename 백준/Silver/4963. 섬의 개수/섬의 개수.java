import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static final int MAX = 55;
	static boolean[][] map;
	static boolean[][] visited;
	static int[] dirY = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dirX = {0, 1, 1, 1, 0, -1, -1, -1};
	static int N, M, cnt;
	
	public static void dfs(int y, int x) {
		visited[y][x] = true;
		
		for (int i = 0; i < 8; i++) {
			int newY = y + dirY[i];
			int newX = x + dirX[i];
			if (map[newY][newX] && !visited[newY][newX]) {
				dfs(newY, newX);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			if (M == 0 && N == 0) break;
			
			map = new boolean[MAX][MAX];
			visited = new boolean[MAX][MAX];
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()) == 1;
				}
			}
			cnt = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if (map[i][j] && !visited[i][j]) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			bw.write(String.valueOf(cnt));
			bw.newLine();
		}
		bw.close();
		br.close();
	}
}
