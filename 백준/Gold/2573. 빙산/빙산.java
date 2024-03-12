import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, cnt, res;
	static int[][] map;
	static int[][] countMap;
	static boolean[][] visited;
	static int[] dirY = {-1, 1, 0, 0};
	static int[] dirX = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		out : for (int tc = 1; tc <= 1000; tc++) {
			visited = new boolean[M][N];
			countMap = new int[M][N];
			// 4방 탐색
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0) {
						int count = 0;
						for (int k = 0; k < 4; k++) {
							int newY = i + dirY[k];
							int newX = j + dirX[k];
							
							if (0 <= newY && newY < M && 0 <= newX && newX < N && map[newY][newX] == 0) {
								count++;
							}
						}
						countMap[i][j] = count;
					}
				}
			}
			// 맵 한번에 빼주기
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] - countMap[i][j] <= 0) {
						map[i][j] = 0;
					}
					else {
						map[i][j] -= countMap[i][j];
					}
				}
			}
			
			cnt = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] != 0) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			if (cnt >= 2) {
				res = tc;
				break out;
			}
			else {
				res = 0;
			}
		}
		bw.write(String.valueOf(res));
		
		bw.close();
		br.close();
	}

	private static void dfs(int y, int x) {
		visited[y][x] = true;
		
		for (int i = 0; i < 4; i++) {
			int newY = y + dirY[i];
			int newX = x + dirX[i];
			
			if (0 <= newY && newY < M && 0 <= newX && newX < N && !visited[newY][newX] && map[newY][newX] != 0) {
				dfs(newY, newX);
			}
		}
	}
}
