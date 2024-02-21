import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dirY = {-1, 1, 0, 0};
	static int[] dirX = {0, 0, -1, 1};
	static int[][] map;
	static boolean[][][] visited;
	static Queue<int[]> q = new LinkedList<int[]>();
	static int N, M, res;
	
	public static void bfs() {
		while (!q.isEmpty()) {
			int[] d = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int newY = d[0] + dirY[i];
				int newX = d[1] + dirX[i];
				
				if (0 <= newY && newY < N && 0 <= newX && newX < M) {
					if (map[newY][newX] == 1) {
						if (d[2] == 0 && !visited[newY][newX][1]) {
							visited[newY][newX][d[2]] = true;
							map[newY][newX] = map[d[0]][d[1]] + 1;
							q.offer(new int[] {newY, newX, 1});
						}
					}
					else {
						if (!visited[newY][newX][d[2]]) {
							visited[newY][newX][d[2]] = true;
							map[newY][newX] = map[d[0]][d[1]] + 1;
							q.offer(new int[] {newY, newX, d[2]});
						}
					}
					if (newY == N - 1 && newX == M - 1) {
						res = map[newY][newX] + 1;
						return;
					}
				}
			}
			res = -1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		if (N - 1 == 0 && M - 1 == 0) {
			System.out.println(1);
			System.exit(0);
		}
		map = new int[N][M];
		visited = new boolean[N][M][2];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		q.offer(new int[] {0,0,0});
		
		bfs();
		
		bw.write(String.valueOf(res));
		
		bw.close();
		br.close();
	}
}
