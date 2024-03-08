import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, M, cnt;
	static int[][] map;
	static int[] dirY = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dirX = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
				
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		
		bw.write(String.valueOf(cnt));
		
		bw.close();
		br.close();
	}


	private static void dfs(int y, int x) {
		map[y][x] = 0;
		
		for (int i = 0; i < 8; i++) {
			int newY = y + dirY[i];
			int newX = x + dirX[i];
			
			if (0 <= newY && newY < M && 0 <= newX && newX < N && map[newY][newX] == 1) {
				dfs(newY, newX);
			}
		}
	}
}
