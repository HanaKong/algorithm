import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int N, cnt;
	static int[] dirY = {-1, 1, 0, 0};
	static int[] dirX = {0, 0, -1, 1};
	
	public static void dfs(int y, int x) {
		visited[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int newY = y + dirY[i];
			int newX = x + dirX[i];
			if (map[newY][newX] == 1 && !visited[newY][newX]) {
				cnt++;
				dfs(newY, newX);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+2][N+2];
		visited = new boolean[N+2][N+2];
		
		for (int i = 0; i < N; i++) {
			String st = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i+1][j+1] = st.charAt(j) - '0';
			}
		}

		List<Integer> list = new ArrayList<>();
		cnt = 1;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					dfs(i, j);
					list.add(cnt);
					cnt = 1;
				}
			}
		}
		bw.write(String.valueOf(list.size()));
		bw.newLine();
		Collections.sort(list);
		for (int i : list) {
			bw.write(String.valueOf(i));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
