import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M, cnt;
	static int[] arr;
	static int[] people;
	static ArrayList<Integer>[] party;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			arr[i] = i;
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int tmp = Integer.parseInt(st.nextToken());
		people = new int[tmp];
		for (int i = 0; i < tmp; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		party = new ArrayList[M];
		for (int i = 0; i < M; i++) {
			party[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine(), " ");
			int pSize = Integer.parseInt(st.nextToken());
			for (int j = 0; j < pSize; j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		for (int i = 0; i < M; i++) {
			int tmp1 = party[i].get(0);
			for (int j = 1; j < party[i].size(); j++) {
				union(tmp1, party[i].get(j));
			}
		}
		
		for (int i = 0; i < M; i++) {
			boolean isP = true;
			int cur = party[i].get(0);
			for (int j = 0; j < people.length; j++) {
				if (find(cur) == find(people[j])) {
					isP = false;
					break;
				}
			}
			if (isP) {
				cnt++;
			}
		}
		
		bw.write(String.valueOf(cnt));
		
		bw.close();
		br.close();
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			arr[b] = a;
		}
	}

	private static int find(int a) {
		if (a == arr[a]) {
			return a;
		}
		return arr[a] = find(arr[a]);
	}
}
