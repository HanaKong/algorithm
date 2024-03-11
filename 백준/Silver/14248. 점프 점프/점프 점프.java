import java.io.*;
import java.util.*;

public class Main {
	static int[] map;
	static boolean[] visited;
	static int[] dirX = {-1, 1};
	static int N, cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1];
		visited = new boolean[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			map[i] = Integer.parseInt(st.nextToken()); 
		}
		int startX = Integer.parseInt(br.readLine());
		
		dfs(startX);
		
		bw.write(String.valueOf(cnt));
		
		bw.close();
		br.close();
	}
	
	static void dfs(int x) {
		visited[x] = true;
		cnt++;
		
		for (int i = 0; i < 2; i++) {
			int newX = x + map[x] * dirX[i];
			
			if (0 < newX && newX <= N && !visited[newX]) {
				dfs(newX);
			}
		}
	}
}
