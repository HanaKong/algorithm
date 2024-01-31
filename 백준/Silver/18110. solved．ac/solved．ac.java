import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[T];
		int sum = 0;
		double count = 0;
		for (int i = 0; i < T; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		count = Math.round(T * 0.15);
		Arrays.sort(arr);
		for (int i = 0; i < (int)count; i++) {
			sum -= arr[i];
		}
		for (int i = arr.length-1; i >= (arr.length-count); i--) {
			sum -= arr[i];
		}
		System.out.print(Math.round(sum / (arr.length-(2*count))));
	}
}