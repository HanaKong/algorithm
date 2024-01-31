import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			String[] sArr = br.readLine().split("");
			int check = 0;
			int cnt = 0;
			for (int j = 0; j < sArr.length; j++) {
				if (sArr[j].equals("(")) {
					cnt++;
				}else {
					cnt--;
				}
				if (cnt < 0) {
					check = 1;
					break;
				}
			}
			if (cnt == 0) {
				check = 0;
			}
			else {
				check = 1;
			}
			if (check == 1) {
				System.out.println("NO");
			}
			else {
				System.out.println("YES");
			}
		}
	}
}