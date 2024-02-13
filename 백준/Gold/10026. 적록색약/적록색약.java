import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static final int MAX = 105;
	static char[][] map;
	static boolean[][] visited;
	static int N, cnt, cnt2;
	static int[] dirY = {-1, 1, 0, 0};
	static int[] dirX = {0, 0, -1, 1};
	
	public static void dfs(int y, int x) {
		visited[y][x] = true;
		char temp = map[y][x];
		
		for (int i = 0; i < 4; i++) {
			int newY = y + dirY[i];
			int newX = x + dirX[i];
			if (!visited[newY][newX] && map[newY][newX] == temp) {
				dfs(newY, newX);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		map = new char[MAX][MAX];
		visited = new boolean[MAX][MAX];
		
		for (int i = 0; i < N; i++) {
			String st = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i+1][j+1] = st.charAt(j);
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		
		visited = new boolean[MAX][MAX];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(map[i][j] == 'G') {
					map[i][j] = 'R';
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					cnt2++;
				}
			}
		}
		
		bw.write(String.valueOf(cnt + " " + cnt2));
		bw.flush();
		
		bw.close();
		br.close();
	}
}
