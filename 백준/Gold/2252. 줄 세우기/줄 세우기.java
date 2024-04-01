import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Queue<Integer> q = new ArrayDeque<Integer>();
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		List<Integer>[] list = new ArrayList[N + 1];
		
		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		int[] arr = new int[N + 1];
		
		for (int i = 1; i <= M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			arr[b]++;
		}
		
		for (int i = 1; i < N + 1; i++) {
			if (arr[i] == 0) {
				q.offer(i);
			}
		}
		
		while (!q.isEmpty()) {
			int tmp = q.poll();
			sb.append(tmp + " ");
			
			for (int i = 0; i < list[tmp].size(); i++) {
				arr[list[tmp].get(i)]--;
				if (arr[list[tmp].get(i)] == 0) {
					q.offer(list[tmp].get(i));
				}
			}
		}
		
		System.out.println(sb);
		
		sc.close();
	}
}