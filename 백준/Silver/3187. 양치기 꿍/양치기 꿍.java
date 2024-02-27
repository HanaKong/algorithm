import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C, cntV, cntK, resV, resK; // v: 늑대 k: 양
	static char[][] map;
	static boolean[][] visited;
	static int[] dirY = {-1, 1, 0, 0};
	static int[] dirX = {0, 0, -1, 1};
	static Queue<int[]> q = new ArrayDeque<int[]>();
	
	public static void bfs() {
		cntV = 0;
		cntK = 0;
		while(!q.isEmpty()) {
			int[] d = q.poll();
			if (map[d[0]][d[1]] == 'v') {
				cntV++;
			}
			else if (map[d[0]][d[1]] == 'k') {
				cntK++;
			}
			for (int i = 0; i < 4; i++) {
				int newY = d[0] + dirY[i];
				int newX = d[1] + dirX[i];
				
				if (0 <= newY && newY < R && 0 <= newX && newX < C && !visited[newY][newX] && map[newY][newX] != '#') {
					visited[newY][newX] = true;
					q.offer(new int[] {newY, newX});
				}
			}
		}
		if (cntK > cntV) {
			resK += cntK;
		}
		else {
			resV += cntV;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0 ; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!visited[i][j] && map[i][j] != '#' ) {
					visited[i][j] = true;
					q.offer(new int[] {i, j});
					bfs();
				}
			}
		}
		System.out.println(resK + " " + resV);
		
		br.close();
	}
}
