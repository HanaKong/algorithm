import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dirY = {-1, 1, 0, 0};
	static int[] dirX = {0, 0, -1, 1};
	
	public static void bfs(int y, int x) {
		visited[y][x] = true;
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {y,x});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int ny = now[0];
			int nx = now[1];
			
			for (int i = 0; i < 4; i++) {
				int newY = ny + dirY[i]; 
				int newX = nx + dirX[i];
				
				if (newY >= 0 && newX >= 0 && newY < N && newX < M) {
					if (map[newY][newX] == 1 && !visited[newY][newX]) {
						q.add(new int[] {newY, newX});
						visited[newY][newX] = true;
						map[newY][newX] = map[ny][nx] + 1;
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) -'0';
			}
		}
		
		bfs(0, 0);
		
		bw.write(String.valueOf(map[N-1][M-1]));
		
		br.close();
		bw.close();
	}
}
