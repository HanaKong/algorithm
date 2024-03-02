import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, res;
	static int[][] map;
	static int[][] cntMap;
	static int[] dirY = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dirX = {-1, 0, 1, -1, 1, -1, 0, 1};
	static Queue<int[]> q = new ArrayDeque<int[]>();
	
	static void bfs() {
		while(!q.isEmpty()) {
			int[] d = q.poll();
			
			for (int i = 0; i < 8; i++) {
				int newY = d[0] + dirY[i];
				int newX = d[1] + dirX[i];
				
				if (0 <= newY && newY < N && 0 <= newX && newX < M) {
					if (cntMap[newY][newX] == 0 && map[newY][newX] != 1) {
						cntMap[newY][newX] = cntMap[d[0]][d[1]] + 1;
						res = Math.max(res, cntMap[newY][newX]);
						q.offer(new int[] {newY, newX});
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		cntMap = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					q.offer(new int[] {i, j});
				}
			}
		}
		
		bfs();
		
		bw.write(String.valueOf(res));
		
		bw.close();
		br.close();
		
	}
}
