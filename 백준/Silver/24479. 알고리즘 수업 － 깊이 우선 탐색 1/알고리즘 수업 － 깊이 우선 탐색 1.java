import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	final static int MAX = 100000 + 10;
	static int N, M, R;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int[] answer;
	static int order;
	
	public static void dfs(int index) {
		visited[index] = true;
		answer[index] = order;
		order++;
		
		for (int i = 0; i < graph[index].size(); i++) {
			int next = graph[index].get(i);
			if(visited[next] == false) {
				dfs(next);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[MAX];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		visited = new boolean[MAX];
		answer = new int[MAX];
		order = 1;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x].add(y);
			graph[y].add(x);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}
		
		dfs(R);
		
		for (int i = 1; i <= N; i++) {
			bw.write(String.valueOf(answer[i]));
			bw.newLine();
		}
		
		bw.close();
		br.close();
	}
}
