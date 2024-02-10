import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static int N;
	public static int M;
	public static int[] arr;
	public static int[] output;
	public static boolean[] select;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		output = new int[N];
		select = new boolean[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		permutation(0);
		System.out.println(sb);
	}
	public static void permutation(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < N; i++) {
				if (output[i] != 0) {
					sb.append(output[i] + " ");
					if ((i+1) % M == 0) {
						sb.append("\n");
					}
				}
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!select[i]) {
				output[cnt] = arr[i];
				select[i] = true;
				permutation(cnt + 1);
				select[i] = false;
			}
		}
	}
}
