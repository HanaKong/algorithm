import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String[] arr = br.readLine().split(" ");
			for (int j = 0; j < arr.length; j++) {
				StringBuffer sb = new StringBuffer(arr[j]);
				String str = sb.reverse().toString();
				arr[j] = str;
				System.out.print(arr[j] + " ");
			}
		}
	}
}