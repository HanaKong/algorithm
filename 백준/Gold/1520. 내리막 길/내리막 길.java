import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int M, N, cnt;
	static int[][] map, dp;
	static int[] dirY = {-1, 1, 0, 0};
	static int[] dirX = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		dp = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		bw.write(String.valueOf(dfs(0, 0)));
		
		bw.close();
		br.close();
	}

	private static int dfs(int y, int x) {
		// 도달 -> 추가 탐색 필요 없다
		if (y == M-1 && x == N-1) {
			return 1;
		}
		// -1 이 아니다 = 방문 했다
		if (dp[y][x] != -1) {
			return dp[y][x];
		}
		
		dp[y][x] = 0;
		for (int i = 0; i < 4; i++) {
			int newY = y + dirY[i];
			int newX = x + dirX[i];
			
			if (0 <= newY && newY < M && 0 <= newX && newX < N) {
				if (map[newY][newX] < map[y][x]) {
					dp[y][x] += dfs(newY, newX); 
				}
			}
		}
		return dp[y][x];
	}
}
