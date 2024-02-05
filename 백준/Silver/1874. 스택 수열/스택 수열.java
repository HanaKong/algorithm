import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Stack<Integer> st = new Stack<>();
		
		int num = 1;
		boolean res = true;
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < N; i++) {
			int number = arr[i];
			if (number >= num) {
				while (number >= num) {
					st.push(num++);
					sb.append("+\n");
				}
				st.pop();
				sb.append("-\n");
			}
			else {
				int n = st.pop();
				if (n > number) {
					System.out.println("NO");
					res = false;
					break;
				} else {
					sb.append("-\n");
				}
			}
		}
		if (res) {
			System.out.println(sb.toString());
		}
	}
}