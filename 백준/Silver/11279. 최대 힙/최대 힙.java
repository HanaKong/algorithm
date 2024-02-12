import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		
		for (int i = 0; i < N; i++) {
			int A = sc.nextInt();
			if (A == 0) {
				if (q.isEmpty()) {
					System.out.println("0");
				}else {
					System.out.println(q.poll());
				}
			}
			else {
				q.offer(A);
			}
		}
	}
}
