import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int N, cnt;
	static int[] dirY = {-1, 1, 0, 0};
	static int[] dirX = {0, 0, -1, 1};
	
	public static void dfs(int y, int x, int H) {
		visited[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int newY = y + dirY[i];
			int newX = x + dirX[i];
			
			if (!visited[newY][newX] && (map[newY][newX] > H)) {
				dfs(newY, newX, H);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+2][N+2];
		visited = new boolean[N+2][N+2];
		
		int maxNum = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int A = Integer.parseInt(st.nextToken());
				map[i+1][j+1] = A;
				if (A > maxNum) {
					maxNum = A;
				}
			}
		}
		int res = 0;
		for (int a = 0; a <= maxNum; a++) {
			int cnt = 0;
			visited = new boolean[N+2][N+2];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(!visited[i][j] && map[i][j] > a) {
						cnt++;
						dfs(i, j, a);
					}
				}
			}
			if (cnt > res) {
				res = cnt;
			}
		}
		bw.write(String.valueOf(res));
		bw.flush();
		
		br.close();
		bw.close();
	}
}
