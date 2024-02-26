import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, r1, r2, c1, c2;
	static int[][] map;
	static int[] dirY = {-2, -2, 0, 0, 2, 2};
	static int[] dirX = {-1, 1, -2, 2, -1, 1};
	static Queue<int[]> q = new ArrayDeque<int[]>();
	
	public static void bfs() {
		q.offer(new int[] {r1, c1});
		
		while (!q.isEmpty()) {
			int[] d = q.poll();
			
			for (int i = 0; i < 6; i++) {
				int newY = d[0] + dirY[i];
				int newX = d[1] + dirX[i];
				
				if (0 <= newY && newY < N && 0 <= newX && newX < N && map[newY][newX] == 0) {
					map[newY][newX] = map[d[0]][d[1]] + 1;
					q.offer(new int[] {newY, newX});
				}
				if (newY == r2 && newX == c2) {
					System.out.println(map[newY][newX]);
					return;
				}
			}
		}
		System.out.println(-1);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		bfs();
		
		br.close();
	}
}