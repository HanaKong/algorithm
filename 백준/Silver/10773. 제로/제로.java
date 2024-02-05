import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		Stack<Integer> st = new Stack<>();
		
		int sum = 0;
		for (int i = 0; i < T; i++) {
			int temp = Integer.parseInt(br.readLine());
			if (temp != 0) {
				sum += st.push(temp);
			}else {
				sum -= st.pop();
			}
		}
		System.out.println(sum);
	}
}