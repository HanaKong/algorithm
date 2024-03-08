import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dirY = {-1, 1, 0, 0};
	static int[] dirX = {0, 0, -1, 1};
	static char[][] map;
	static int N, M, cnt; 
	static Queue<int[]> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'I') {
					q.offer(new int[] {i, j});
				}
			}
		}
		
		bfs();
		if (cnt != 0) {
			bw.write(String.valueOf(cnt));
		}
		else {
			bw.write("TT");
		}
		
		bw.close();
		br.close();
	}

	private static void bfs() {
		while(!q.isEmpty()) {
			int[] d = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int newY = d[0] + dirY[i];
				int newX = d[1] + dirX[i];
				
				if(0 <= newY && newY < N && 0 <= newX && newX < M && map[newY][newX] != 'X' && map[newY][newX] != '0') {
					if(map[newY][newX] == 'P') {
						cnt++;
					}
					map[newY][newX] = '0';
					q.offer(new int[] {newY, newX});
				}
			}
		}
	}
}
