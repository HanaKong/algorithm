import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int len = str.length();
		int check = 0;
		
		for (int i = 0; i <= len/2; i++) {
			if (str.charAt(i) == str.charAt(len - (i+1))) {
				check = 1;
			}else { 
				check = 0;
				break;
			}
		}
		System.out.println(check);
	}
}