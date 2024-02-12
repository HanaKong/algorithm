import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	final static int MAX = 50 + 5;
	static boolean[][] map;
	static int T, N, M, K;
	static int[] dirY = {-1, 1, 0, 0};
	static int[] dirX = {0, 0, -1, 1};
	
	public static void dfs(int y, int x) {
		map[y][x] = false;
		for (int i = 0; i < 4; i++) {
			int newY = y + dirY[i];
			int newX = x + dirX[i];
			if (map[newY][newX]) {
				dfs(newY, newX);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new boolean[MAX][MAX];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y + 1][x + 1] = true;
			}
			
			int anwser = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if (map[i][j]) {
						anwser++;
						dfs(i,j);
					}
				}
			}
			bw.write(String.valueOf(anwser));
			bw.newLine();
		}
		
		bw.close();
		br.close();
	}
}
