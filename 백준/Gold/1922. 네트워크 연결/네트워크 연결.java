import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] edges = new int[M][3];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
			edges[i][2] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		arr = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}
		
		int ans = 0, cnt = 0;
		
		for (int i = 0; i < M; i++) {
			int x = find(edges[i][0]);
			int y = find(edges[i][1]);
			
			if (x != y) {
				union(x, y);
				ans += edges[i][2];
				cnt++;
			}
			if (cnt == (N-1)) break;
		}
		
		System.out.println(ans);
		
		br.close();
	}
	
	static void union(int a, int b) {
		arr[b] = a;
	}
	
	static int find(int a) {
		if (a != arr[a]) {
			arr[a] = find(arr[a]); 
		}
		return arr[a];
	}
}
 