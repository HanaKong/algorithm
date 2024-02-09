import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			q.offer(Integer.parseInt(st.nextToken()));
		}
		
		int time = 0;
		int bw = 0;
		Queue<Integer> q1 = new LinkedList<Integer>();
		for (int i = 0; i < w; i++) {
			q1.offer(0);
		}
		while (!q1.isEmpty()) {
			time++;
			bw -= q1.poll();
			if (!q.isEmpty()) {
				if (q.peek() + bw <= l) {
					bw += q.peek();
					q1.offer(q.poll());
				}
				else {
					q1.offer(0);
				}
			}
		}
		System.out.println(time);
	}
}
