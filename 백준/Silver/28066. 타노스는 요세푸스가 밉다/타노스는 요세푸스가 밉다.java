import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		while (q.size() != 1) {
			q.offer(q.poll());
			for (int i = 0; i < K - 1; i++) {
				q.poll();
				if (q.size() == 1) {
					break;
				}
			}
				
		}
		System.out.println(q.poll());
	}
}
