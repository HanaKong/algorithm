import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuffer sb = new StringBuffer();
		
		int N = sc.nextInt();
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			list.add(sc.nextInt());
		}
		
		Collections.sort(list);
		
		for (int v : list) {
			sb.append(v).append("\n");
		}
		System.out.println(sb);
	}
}
