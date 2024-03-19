import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i;
		}
		
		int res = 0;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(!union(a, b)) {
				res = i;
				break;
			}
		}
		
		bw.write(String.valueOf(res));
		
		bw.close();
		br.close();
	}

	public static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a == b) {
			return false;
		}
		arr[b] = a;
		return true;
		
	}
	
	public static int find(int a) {
		if (a == arr[a]) return a;
		return arr[a] = find(arr[a]);
	}
}
