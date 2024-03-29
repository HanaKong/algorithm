import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o1) == Math.abs(o2)) {
					return o1 - o2;
				}
				return Math.abs(o1) - Math.abs(o2); 
			}
		});
		
		
		for (int i = 0; i < N; i++) {
			int A = sc.nextInt();
			if (A == 0) {
				if (q.isEmpty()) {
					System.out.println(0);
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
