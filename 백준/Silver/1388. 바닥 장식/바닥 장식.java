import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static char[][] map;
	static boolean[][] visited;
	
	public static void dfs(int y, int x) {
		visited[y][x] = true;
		
		if (map[y][x] == '-' && map[y][x + 1] == '-') dfs(y, x+1);
		if (map[y][x] == '|' && map[y + 1][x] == '|') dfs(y+1, x);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new char[N+2][M+2];
		visited = new boolean[N+2][M+2];
		
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = str.charAt(j - 1);
			}
		}
		
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (visited[i][j] == false) {
					dfs(i, j);
					answer++;
				}
			}
		}
		bw.write(String.valueOf(answer));
		
		br.close();
		bw.close();
	}
}