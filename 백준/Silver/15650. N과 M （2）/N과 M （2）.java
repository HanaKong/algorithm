import java.util.Scanner;

public class Main {
	
	public static int[] arr;
	public static boolean[] visited;
	public static int N;
	public static int M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		visited = new boolean[N + 1];
		combination(1, 0);
	}
	public static void combination(int start, int cnt) {
		if (cnt == M) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
				if ((i+1) % M == 0) {
					System.out.println();
				}
			}
			return;
		}
		for (int i = start; i <= N; i++) {
			arr[cnt] = i;
			combination(i+1, cnt+1);
		}
	}
}
