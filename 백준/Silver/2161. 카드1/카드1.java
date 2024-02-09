import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		StringBuffer sb = new StringBuffer();
		
		while (q.size() != 1) {
			int tmp = q.poll();
			sb.append(tmp + " ");
			q.offer(q.poll());
		}
		sb.append(q.poll());
		
		System.out.println(sb);
	}
}
