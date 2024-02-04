import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		double sum = 0;
		int cnt = 0;
		for (int i = 0; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String A = st.nextToken();
			double B = Double.parseDouble(st.nextToken());
			switch (st.nextToken()){
				case "A+": {
					sum += B * 4.5;
					cnt += B;
					break;
				}
				case "A0": {
					sum += B * 4.0;
					cnt += B;
					break;
				}
				case "B+": { 
					sum += B * 3.5;
					cnt += B;
					break;
				}
				case "B0": {
					sum += B * 3.0;
					cnt += B;
					break;
				}
				case "C+": {
					sum += B * 2.5;
					cnt += B;
					break;
				}
				case "C0": {
					sum += B * 2.0;
					cnt += B;
					break;
				}
				case "D+": {
					sum += B * 1.5;
					cnt += B;
					break;
				}
				case "D0": {
					sum += B * 1.0;
					cnt += B;
					break;
				}
				case "F" : {
					sum += 0;
					cnt += B;
					break;
				}
				case "P" : {
					sum += 0;
				}
			}
		}
		System.out.printf("%.6f",sum/cnt);
	}
}
