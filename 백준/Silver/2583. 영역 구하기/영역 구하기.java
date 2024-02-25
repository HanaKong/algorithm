import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[] dirY = {-1, 1, 0, 0};
	static int[] dirX = {0, 0, -1, 1};
	static int M, N, K, cnt;
	
	public static void dfs(int y, int x) {
		map[y][x] = 2;
		for (int i = 0; i < 4; i++) {
			int newY = y + dirY[i];
			int newX = x + dirX[i];
			if (0 <= newY && newY < M && 0 <= newX && newX < N && map[newY][newX] != 1) {
				if (map[newY][newX] == 0) {
					cnt++;
					dfs(newY, newX);
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[M+1][N+1];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int startY = Integer.parseInt(st.nextToken());
			int startX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			
			for (int j = startX; j < endX; j++) {
				for (int k = startY; k < endY; k++) {
					map[j][k] = 1;
				}
			}
		}
		
		List<Integer> list = new ArrayList<>();
		cnt = 1;
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					dfs(i, j);
					list.add(cnt);
					cnt = 1;
				}
			}
		}
		Collections.sort(list);
		bw.write(String.valueOf(list.size()));
		bw.newLine();
		for (int i : list) {
			bw.write(i + " ");
		}
		
		bw.close();
		br.close();
	}
}
