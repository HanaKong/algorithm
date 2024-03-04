import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int R, C, max;
	static int[] dirY = {-1, 1, 0, 0};
	static int[] dirX = {0, 0, -1, 1};
	static int[][] map;
	static boolean[] alphabet = new boolean[26];
	
	public static void dfs(int y, int x, int cnt) {
		alphabet[map[y][x]] = true;
		
		for (int i = 0; i < 4; i++) {
			int newY = y + dirY[i];
			int newX = x + dirX[i];
			
			if (0 <= newY && newY < R && 0 <= newX && newX < C && !alphabet[map[newY][newX]]) {
				dfs(newY, newX, cnt+1);
			}
		}
		max = Math.max(max, cnt);
		alphabet[map[y][x]] = false;
	}	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j) - 'A';
			}
		}
		
		dfs(0, 0, 1);
		
		bw.write(String.valueOf(max));;
		
		bw.close();
		br.close();
	}
}