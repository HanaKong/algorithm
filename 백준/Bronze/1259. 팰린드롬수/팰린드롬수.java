import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String num = br.readLine();
			boolean check = true;
			int len = num.length();
			
			if (num.equals("0")) break;
			
			for (int i = 0; i < len/2; i++) {
				if (num.charAt(i) != num.charAt(len-(i+1))) {
					check = false;
				}
			}
			if (check) {
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}
		}
	}
}