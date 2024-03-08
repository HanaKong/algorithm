import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int T, H, W, cnt;
	static int[] dirY = {-1, 1, 0, 0};
	static int[] dirX = {0, 0, -1, 1};
	static char[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			cnt = 0;
			
			map = new char[H][W];
			
			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				map[i] = str.toCharArray();
			}
			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == '#') {
						dfs(i, j);
						cnt++;
					}
				}
			}
			bw.write(String.valueOf(cnt));
			bw.newLine();
		}
		bw.close();
		br.close();
	}

	static void dfs(int y, int x) {
		map[y][x] = '.';
		
		for (int i = 0; i < 4; i++) {
			int newY = y + dirY[i];
			int newX = x + dirX[i];
			
			if(0 <= newY && newY < H && 0 <= newX && newX < W && map[newY][newX] == '#') {
				dfs(newY, newX);
			}
		}
	}
}
