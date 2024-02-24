import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int[] dirY = {-1, 1, 0, 0};
	static int[] dirX = {0, 0, -1, 1};
	static int N, M, K, res, temp;
	static Queue<int[]> q = new ArrayDeque<int[]>();
	
	public static void bfs() {
		while(!q.isEmpty()) {
			int[] d = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int newY = d[0] + dirY[i];
				int newX = d[1] + dirX[i];
				
				if (0 <= newY && newY < N && 0 <= newX && newX < M && !visited[newY][newX] && map[newY][newX] == 1) {
					q.offer(new int[] {newY, newX});
					visited[newY][newX] = true;
					temp++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			map[y][x] = 1;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					visited[i][j] = true;
					temp = 1;
					q.offer(new int[] {i, j});
					bfs();
					res = Math.max(res, temp);
				}
			}
		}
		
		bw.write(String.valueOf(res));
		
		bw.close();
		br.close();
	}
}
