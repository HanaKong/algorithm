import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			long[] d = new long[N+1];
			for (int i = 1; i < N + 1; i++) {
				if (i < 4) {
					d[i] = 1;
				}
				else {
					d[i] = -1;
				}
			}
			for (int i = 4; i <= N; i++) {
				d[i] = d[i - 2] + d[i - 3];
			}
			bw.write(String.valueOf(d[N]));
			bw.newLine();
		}
		
		bw.close();
		br.close();
	}
}
