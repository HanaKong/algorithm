import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		Stack<Integer> st = new Stack<>();
		
		for (int i = 0; i < T; i++) {
			st.push(Integer.parseInt(br.readLine()));
		}
		
		int max = st.peek();
		int cnt = 1;
		
		for (int i = 0; i < T; i++) {
			int a = st.pop();
			if (a > max) {
				max = a;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
