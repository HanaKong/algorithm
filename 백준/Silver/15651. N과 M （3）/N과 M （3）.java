import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int M;
	public static int[] arr;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		
		permutation(0);
		System.out.println(sb);
	}
	public static void permutation(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i] + " ");
				if ((i+1) % M == 0) {
					sb.append("\n");
				}
			}
			return;
		}
		for (int i = 1; i <= N; i++) {
				arr[cnt] = i;
				permutation(cnt + 1);
		}
	}
}
