import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int[] arr = {25, 10, 5, 1};
		
		for (int i = 0; i < T; i++) {
			int[] cnt = new int[4];
			int D = Integer.parseInt(br.readLine());
			for (int j = 0; j < arr.length; j++) {
				cnt[j] = D / arr[j];
				D %= arr[j];
				System.out.print(cnt[j] + " ");
			}
			System.out.println();
		}
	}
}