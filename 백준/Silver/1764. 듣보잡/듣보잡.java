import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		List<String> str = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			String a = sc.next();
			map.put(a, 0);
		}
		for (int i = 0; i < M; i++) {
			String b = sc.next();
			if (map.containsKey(b)) {
				str.add(b);
			}
		}
		
		Collections.sort(str);
		
		System.out.println(str.size());
		
		for (String i : str) {
			System.out.println(i);
		}
		
		sc.close();
	}
}
