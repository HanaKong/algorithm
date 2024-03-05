import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int MAX = 100001;
	static Queue<Integer> q = new ArrayDeque<>();
	static int[] map;
	static int[] dirX = {-1, 1, 2};
	static int N, K, cnt;
	static int res = Integer.MAX_VALUE;
	
	public static void bfs() {
		while(!q.isEmpty()) {
			int d = q.poll();
			
			if (res < map[d]) return;
			if (res >= map[d] && d == K) {
				res = map[d];
				cnt++;
			}
			
			for (int i = 0; i < 3; i++) {
				int newX;
				if (i < 2) newX = d + dirX[i];
				else newX = d * dirX[i];
				
				if (0 <= newX && newX < MAX) {
					if (map[newX] == 0 || map[newX] >= map[d] + 1) {
						map[newX] = map[d] + 1;
						q.offer(newX);
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
		K = Integer.parseInt(st.nextToken());
		
		map = new int[MAX];
		
		q.offer(N);
		bfs();
		
		bw.write(String.valueOf(res));
		bw.newLine();
		bw.write(String.valueOf(cnt));
		
		bw.close();
		br.close();
	}
}
