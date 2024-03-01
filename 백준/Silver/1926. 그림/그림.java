import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, M, cnt;
	static int[] dirY = {-1, 1, 0, 0};
	static int[] dirX = {0, 0, -1, 1};
	static boolean[][] map;
	
	static void dfs(int y, int x) {
		map[y][x] = false;
		for (int i = 0; i < 4; i++) {
			int newY = y + dirY[i];
			int newX = x + dirX[i];
			if (0 > newY || newY >= N || 0 > newX || newX >= M) continue;
			else if (map[newY][newX]) {
				cnt++;
				dfs(newY, newX);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					map[i][j] = true;
				}
			}
		}
		cnt = 1;
		int max = 0;
		int printCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j]) {
					printCnt++;
					dfs(i, j);
					if (cnt > max)	max = cnt;
					cnt = 1;
				}
			}
		}
		bw.write(String.valueOf(printCnt));
		bw.newLine();
		bw.write(String.valueOf(max));
		
		bw.close();
		br.close();
	}
}
