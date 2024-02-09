import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int switch_cnt, student_cnt, gender, n;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		switch_cnt = Integer.parseInt(br.readLine());

		arr = new int[switch_cnt + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= switch_cnt; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		student_cnt = Integer.parseInt(br.readLine());
		for (int i = 1; i <= student_cnt; i++) {
			st = new StringTokenizer(br.readLine());
			gender = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());

			if (gender == 1) {
				male();
			} else {
				female();
			}
		}
		for (int i = 1; i <= switch_cnt; i++) {
			System.out.print(arr[i] + " ");
			if (i % 20 == 0) {
				System.out.println();
			}
		}
	}

	static void male() {
		for (int j = n; j <= switch_cnt; j += n) {
			if (j % n == 0) {
				arr[j] = (arr[j] == 1) ? 0 : 1;
			}
		}
	}

	static void female() {
		arr[n] = arr[n] == 0 ? 1 : 0;
		int cnt = 1;
		while (n - cnt >= 1 && n + cnt <= switch_cnt) {
			if (arr[n - cnt] == arr[n + cnt]) {
				arr[n - cnt] = arr[n - cnt] == 0 ? 1 : 0;
				arr[n + cnt] = arr[n + cnt] == 0 ? 1 : 0;
			} else {
				break;
			}
			cnt++;
		}
	}
}