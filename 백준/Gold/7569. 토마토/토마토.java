import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][][] map;
	static int[] dirZ = {-1, 1, 0, 0, 0, 0};
	static int[] dirY = {0, 0, -1, 1, 0, 0};
	static int[] dirX = {0, 0, 0, 0, -1, 1};
	static int M, N, H, zeroCnt, max;
	static Queue<int[]> q = new LinkedList<int[]>();
	
	public static void bfs() {
		while(!q.isEmpty()) {
			int[] t = q.poll();
			
			for (int i = 0; i < 6; i++) {
				int nZ = t[0] + dirZ[i];
				int nY = t[1] + dirY[i];
				int nX = t[2] + dirX[i];
				
				if (0 <= nZ && nZ < H && 0 <= nY && nY < N && 0 <= nX && nX < M && map[nZ][nY][nX] == 0) {
					zeroCnt--;
					q.offer(new int[] {nZ, nY, nX});
					map[nZ][nY][nX] = map[t[0]][t[1]][t[2]] + 1;
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
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][N][M];
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if (map[i][j][k] == 1) {
						q.offer(new int[] {i, j, k});
					}
					else if (map[i][j][k] == 0) {
						zeroCnt++;
					}
				}
			}
		}
		
		bfs();
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					max = Math.max(max, map[i][j][k]);
				}
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
