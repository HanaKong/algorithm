import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			Stack<Character> st = new Stack<>();
			String str = sc.next();
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				if (st.isEmpty()) {
					st.push(c);
				}
				else if (!st.isEmpty()) {
					if (st.peek() == c) {
						st.pop();
					}else {
						st.push(c);
					}
				}
			}
			if(st.isEmpty()) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
