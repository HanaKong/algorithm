import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for (int i = 0; i < T; i++) {
			String str = br.readLine();
			
			boolean[] arr = new boolean[26];
			int prev = 0;
			int check = 0;
			
			for (int j = 0; j < str.length(); j++) {
				int now = str.charAt(j);
				
				if (prev != now) {
					if (arr[now - 'a'] == false) {
						arr[now - 'a'] = true;
						prev = now;
					}
					else {
						check = 1;
						break;
					}
				}
			}
			if (check != 1) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
