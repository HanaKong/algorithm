import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static int M, N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		M = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		
		// 부모 노드 배열
		arr = new int[M + 1];
		// 도시 연결 데이터
		int[][] map = new int[M + 1][M + 1];
		// 여행 도시 정보
		int[] travel = new int[N + 1];
		
		// 부모 노드 초기화
		for (int i = 0; i < M + 1; i++) {
			arr[i] = i;
		}
		
		// 도시 연결 데이터 입력 받기
		StringTokenizer  st;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 여행 도시 정보 입력 받기
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			travel[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= M; j++) {
				// 도시가 연결되있다면, 연결되어 있다! 라고 집합을 합치는 거죠...
				if (map[i][j] == 1) {
					union(i, j);
				}
			}
		}
		
		// 여행 도시 정보가 모두 연결되어 있는지 확인하기 위해 비교 대상을 부모노드로 설정해주고
		int idx = find(travel[1]);
		boolean check = true;
		for (int i = 2; i < travel.length; i++) {
			// 비교 시작
			if (idx != find(travel[i])) {
				check = false;
				break;
			}
		}
		if (check) bw.write("YES");
		else bw.write("NO");
		
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
	
	public static int find(int a) {
		if (a == arr[a]) {
			return a;
		}
		else {
			return arr[a] = find(arr[a]);
		}
	}
}
