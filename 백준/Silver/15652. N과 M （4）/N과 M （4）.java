import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[M];
		
		dfs(1, 0);
				
	}
	public static void dfs(int st, int depth) {
		if (depth == M) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = st; i <= N; i++) {
			arr[depth] = i;
			dfs(i, depth + 1);
		}
	}
}
