import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, cntB, cntW, cnt;
	static char[][] map;
	static boolean[][] visited;
	static int[] dirY = {-1, 1, 0, 0};
	static int[] dirX = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[M][N];
		visited = new boolean[M][N];
		
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				cnt = 0;
				char t = map[i][j];
				if (!visited[i][j]) {
					dfs(i, j, t);
				}
				if (t == 'B') {
					cntB += cnt * cnt;
				}
				else {
					cntW += cnt * cnt;
				}
			}
		}
		bw.write(String.valueOf(cntW + " " + cntB));
		
		bw.close();
		br.close();
	}

	private static void dfs(int y, int x, char t) {
		visited[y][x] = true;
		cnt++;
		
		for (int i = 0; i < 4; i++) {
			int newY = y + dirY[i];
			int newX = x + dirX[i];
			if (0 > newY || newY >= M || 0 > newX || newX >= N || visited[newY][newX]) continue;
			if (map[newY][newX] == t) {
				dfs(newY, newX, t);
			}
		}
	}
}
