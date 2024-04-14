import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(sc.nextInt());
		}
		Collections.sort(list);
		
		int M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			boolean check = false;
			int target = sc.nextInt();
			int st = 0;
			int end = list.size() - 1;
			while (st <= end) {
				int mid = (st + end) / 2;
				int midValue = list.get(mid);
				if (midValue > target) {
					end = mid - 1;
				}
				else if (midValue < target) {
					st = mid + 1;
				}
				else {
					check = true;
					break;
				}
			}
			if (check) {
				sb.append(1).append("\n");
			}
			else {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
		sc.close();
	}
}
