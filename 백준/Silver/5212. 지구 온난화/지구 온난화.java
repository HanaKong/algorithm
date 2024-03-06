import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dirY = {-1, 1, 0, 0};
	static int[] dirX = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		char[][] afterMap = new char[R][C];
		
		int startR = 10;
		int startC = 10;
		int endR = 0;
		int endC = 0;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'X') {
					int cnt = 0;
					for (int k = 0; k < 4; k++) {
						int newY = i + dirY[k];
						int newX = j + dirX[k];
						
						if (newY < 0 || newY >= R || newX < 0 || newX >= C || map[newY][newX] == '.') {
							cnt++;
						}
					}
					
					if (cnt < 3) {
						afterMap[i][j] = 'X';
						startR = Math.min(startR, i);
						startC = Math.min(startC, j);
						endR = Math.max(endR, i);
						endC = Math.max(endC, j);
						
					}
					else {
						afterMap[i][j] = '.';
					}
				}
				else {
					afterMap[i][j] = '.';
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = startR; i <= endR; i++) {
			for (int j = startC; j <= endC; j++) {
				sb.append(afterMap[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
}
