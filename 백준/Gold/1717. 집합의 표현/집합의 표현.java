import java.util.*;
import java.io.*;

public class Main {
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N + 1];
		
		for (int i = 0; i < N + 1; i++) {
			arr[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			if (A == 0) {
				union(B, C);
			}
			else {
				if (check(B, C)) {
					bw.write("YES");
				}
				else {
					bw.write("NO");
				}
				bw.newLine();
			}
		}
		bw.close();
		br.close();
	}
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			arr[b] = a;
		}
	}
	private static int find(int a) {
		if (a == arr[a]) {
			return a;
		}
		else {
			return arr[a] = find(arr[a]);
		}
	}
	private static boolean check(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) {
			return true;
		}
		return false;
	}
}
