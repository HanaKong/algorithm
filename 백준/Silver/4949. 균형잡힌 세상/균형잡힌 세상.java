import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = "";
		while(!(str= sc.nextLine()).equals(".")) {
			boolean chk = true;
			Stack<Character> st = new Stack<>();
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if(c == '(' || c == '[' || c == '{') {
					st.push(c);
				}
				else if (c == ')' || c == ']' || c == '}') {
					if (!st.isEmpty()) {
						if (c == ')' && st.peek() == '(') {
							st.pop();
						}
						else if (c == '}' && st.peek() == '{' ) {
							st.pop();
						}
						else if (c == ']' && st.peek() == '[') {
							st.pop();
						}
						else {
							chk = false;
						}
					}
					else {
						chk = false;
					}
				}
			}
			if (chk) {
				if (st.isEmpty()) {
					System.out.println("yes");
				}
				else {
					System.out.println("no");
				}
			}else {
				System.out.println("no");
			}
		}
	}
}