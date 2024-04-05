import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	
	static ArrayList<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String text = br.readLine();
		String pattern = br.readLine();
		
		KMP(text, pattern);
		
		bw.write(String.valueOf(list.size()));
		bw.newLine();
		for (int i : list) {
			bw.write(String.valueOf(i) + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	public static int[] getPi(String pattern) {
		int len = pattern.length();
		int[] pi = new int[len];
		char[] pt = pattern.toCharArray();
		
		int j = 0;
		for (int i = 1; i < len; i++) {
			while (j > 0 && pt[i] != pt[j]) {
				j = pi[j-1];
			}
			if (pt[i] == pt[j]) {
				pi[i] = ++j;
			}
		}
		return pi;
	}
    
	public static void KMP(String text, String pattern) {
		list = new ArrayList<>();
		int[] pi = getPi(pattern);
		char[] org = text.toCharArray();
		char[] pt = pattern.toCharArray();
		
		int j = 0;
		for (int i = 0; i < text.length(); i++) {
			while (j > 0 && org[i] != pt[j]) {
				j = pi[j-1];
			}
			if (org[i] == pt[j]) {
				if (j == pattern.length() - 1) {
					list.add(i - pattern.length() + 2);
					j = pi[j];
				} else {
					j++;
				}
			}
		}
	}
}
