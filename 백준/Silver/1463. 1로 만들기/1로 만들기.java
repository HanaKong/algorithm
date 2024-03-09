import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] d = new int[(int)10e5 + 1];
		
		for (int i = 2; i < N + 1; i++) {
			d[i] = d[i-1] + 1;
			
			if (i % 2 == 0) {
				d[i] = Math.min(d[i], d[i / 2] + 1);
			}
			if (i % 3 == 0) {
				d[i] = Math.min(d[i], d[i / 3] + 1);
			}
		}
		bw.write(String.valueOf(d[N]));
		
		bw.close();
		br.close();
	}
}
