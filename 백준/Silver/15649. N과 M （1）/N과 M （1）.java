import java.util.Scanner;

public class Main {
	static int M;
	static int[] num;
	static int[] arr;
	static boolean[] select;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		num = new int[M];
		select = new boolean[N];
		
		permutation(0, M);
	}
	public static void permutation(int cnt, int M) {
		if (cnt == M) {
			for (int i = 0; i < num.length; i++) {
				System.out.print(num[i] + " ");
				if ((i+1) % M == 0) {
					System.out.println();
				}
			}
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (!select[i]) {
				num[cnt] = arr[i];
				select[i] = true;
				permutation(cnt + 1, M);
				select[i] = false;
			}
		}
	}
}