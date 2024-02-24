import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dirY = {-1, 1, 0, 0};
	static int[] dirX = {0, 0, -1, 1};
	static Queue<int[]> q = new ArrayDeque<int[]>();
	
	public static void bfs() {
		while(!q.isEmpty()) {
			int[] d = q.poll();
			for (int i = 0; i < 4; i++) {
				int newY = d[0] + dirY[i];
				int newX = d[1] + dirX[i];
				
				if (0 <= newY && newY < N && 0 <= newX && newX < M && !visited[newY][newX]) {
					visited[newY][newX] = true;
					map[newY][newX] = map[d[0]][d[1]] + 1;
					q.offer(new int[] {newY, newX});
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
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					q.offer(new int[] {i, j});
					map[i][j] = 0;
					visited[i][j] = true;
				}
				else if(map[i][j] == 0) {
					visited[i][j] = true;
				}
			}
		}
		
		bfs();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j]) {
					map[i][j] = -1;
				}
				bw.write(map[i][j] + " ");
			}
			bw.newLine();
		}
		
		bw.close();
		br.close();
	}
}
