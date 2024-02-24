import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int T, I, endY, endX, startY, startX;
	static int[][] map;
	static int[] dirY = {2, 2, -2, -2, -1, -1, 1, 1};
	static int[] dirX = {-1, 1, -1, 1, -2, 2, -2, 2};
	static Queue<int[]> q = new ArrayDeque<int[]>();
	static StringTokenizer st;
	
	static void bfs() {
		if (startY == endY && startX == endX) {
			return;
		}
		while(!q.isEmpty()) {
			int[] d = q.poll();
			for (int i = 0; i < 8; i++) {
				int newY = d[0] + dirY[i];
				int newX = d[1] + dirX[i];
				if (0 <= newY && newY < I && 0 <= newX && newX < I && map[newY][newX] == 0) {
					q.offer(new int[] {newY, newX});
					map[newY][newX] = map[d[0]][d[1]] + 1;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			I = Integer.parseInt(br.readLine());
			map = new int[I][I];
			
			st = new StringTokenizer(br.readLine());
			startY = Integer.parseInt(st.nextToken());
			startX = Integer.parseInt(st.nextToken());
			q.offer(new int[] {startY, startX});
			
			st = new StringTokenizer(br.readLine());
			endY = Integer.parseInt(st.nextToken());
			endX = Integer.parseInt(st.nextToken());
			
			bfs();
			
			bw.write(String.valueOf(map[endY][endX]));
			bw.newLine();
		}
		
		bw.close();
		br.close();
	}
}
