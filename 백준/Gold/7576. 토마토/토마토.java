import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N, zeroCnt;
	static int[][] map;
	static int[] dirY = {-1, 1, 0, 0};
	static int[] dirX = {0, 0, -1, 1};
	
	static Queue<int[]> q = new LinkedList<>();
	
	public static void bfs() {
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			for (int i = 0; i < 4; i++) {
				int newY = temp[0] + dirY[i];
				int newX = temp[1] + dirX[i];
				
				if (newY >= 0 && newX >= 0 && newY < N && newX < M && map[newY][newX] == 0) {
					map[newY][newX] = map[temp[0]][temp[1]] + 1;
					q.offer(new int[] {newY, newX});
					zeroCnt--;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					zeroCnt++;
				}
				else if (map[i][j] == 1) {
					q.offer(new int[] {i, j});
				}
			}
		}
		
		bfs();
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				max = Math.max(max, map[i][j]); 
			}
		}
		
		if (zeroCnt == 0) {
			bw.write(String.valueOf(max-1));
		}
		else {
			bw.write("-1");
		}
		
		bw.close();
		br.close();
	}
}
