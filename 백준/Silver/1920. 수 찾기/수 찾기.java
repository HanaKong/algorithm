import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			System.out.println(binarySearch(arr, Integer.parseInt(st.nextToken()), 0, arr.length-1)); 
		}
	}
	public static int binarySearch(int[] arr, int key, int low, int high) {
		int mid;
		
		if(low <= high) {
			mid = (low+high) / 2;
			
			if(key == arr[mid]) {
				return 1;
			}
			else if (key < arr[mid]) {
				return binarySearch(arr, key, low, mid-1);
			}
			else {
				return binarySearch(arr, key, mid+1, high);
			}
		}
		return 0;
	}
}