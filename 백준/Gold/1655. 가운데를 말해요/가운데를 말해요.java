import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> minQ = new PriorityQueue<>();
		PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
		
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			
			if (minQ.size() == maxQ.size()) {
				maxQ.offer(tmp);
				
				if (!minQ.isEmpty() && (maxQ.peek() > minQ.peek())) {
					minQ.offer(maxQ.poll());
					maxQ.offer(minQ.poll());
				}
			}
			else {
				minQ.offer(tmp);
				
				if (maxQ.peek() > minQ.peek()) {
					minQ.offer(maxQ.poll());
					maxQ.offer(minQ.poll());
				}
			}
			bw.write(String.valueOf(maxQ.peek()));
			bw.newLine();
		}
		bw.close();
		br.close();
	}
}
