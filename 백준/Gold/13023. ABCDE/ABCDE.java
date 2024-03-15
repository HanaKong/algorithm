import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
		static int N, M;
		static List<Integer>[] list;
		static boolean[] visited;	
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		 
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		for (int i = 0; i < N; i++) {
			Collections.sort(list[i]);
		}
		
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited, false);
			dfs(i, 0);
		}
		System.out.println(0);
		
		br.close();
	}

	private static void dfs(int idx, int depth) {
		if (depth == 4) {
			System.out.println(1);
			System.exit(0);
		}
		visited[idx] = true;
		for (int i = 0; i < list[idx].size(); i++) {
			int tmp = list[idx].get(i);
			if (!visited[tmp]) {
				visited[tmp] = true;
				dfs(tmp, depth + 1);
				visited[tmp] = false;
			}
		}
	}
}
