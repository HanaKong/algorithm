import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        // 도시의 개수
		int N = Integer.parseInt(br.readLine());
        // 도로의 개수
		int M = Integer.parseInt(br.readLine());
        
        // 인접리스트
		ArrayList<int[]>[] route = new ArrayList[N + 1];
		ArrayList<int[]>[] reverseRoute = new ArrayList[N + 1];
		
		for (int i = 0; i <= N; i++) {
			route[i] = new ArrayList<>();
			reverseRoute[i] = new ArrayList<>();
		}
		
        // 진입차수 배열
		int[] inDegree = new int[N + 1];
        // 결과 배열
		int[] res = new int[N + 1];
		
		StringTokenizer st;
        // 도시, 도로의 정보
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken()); 
			int B = Integer.parseInt(st.nextToken()); 
			int C = Integer.parseInt(st.nextToken());
			route[A].add(new int[] {B, C});
			reverseRoute[B].add(new int[] {A, C});
			inDegree[B]++;
		}
		st = new StringTokenizer(br.readLine(), " ");
        // 시작 도시
		int start = Integer.parseInt(st.nextToken());
        // 도착 도시
		int end = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(start);
		
        // 위상정렬
		while (!q.isEmpty()) {
			int now = q.poll();
			
			for (int[] next : route[now]) {
				inDegree[next[0]]--;
                
                // 다음 도시의 결과값과
                // 현재 도시의 결과값 + 다음 도시로 가기 위한 도로의 값을 비교
                // 둘 중 더 큰 값을 결과 배열에 저장
				res[next[0]] = Math.max(res[next[0]], res[now] + next[1]);
				
				if (inDegree[next[0]] == 0) {
					q.offer(next[0]);
				}
			}
		}
		// 쉬지 않고 달려야하는 도로의 개수를 세기 위한 변수
		int cnt = 0;
        
        // 중복을 막기 위한 방문 배열
		boolean[] visited = new boolean[N + 1];
		
		q.offer(end);
		
		visited[end] = true;
		
		while (!q.isEmpty()) { 
			int now = q.poll();
			for (int[] prev : reverseRoute[now]) {
                // 이전 도시의 결과값과 도로의 값이 현재 도시의 결과값과 같으면
				if (res[prev[0]] + prev[1] == res[now]) {
                    // 쉬지않고 달려야하는 도로이다
					cnt++;
					
                    // 중복을 막기위해 방문처리가 되어있지 않다면
					if (!visited[prev[0]]) {
                        // 방문처리하고
						visited[prev[0]] = true;
                        // q에 넣어준다
						q.offer(prev[0]);
					}
				}
			}
		}
		
		bw.write(String.valueOf(res[end]));
		bw.newLine();
		bw.write(String.valueOf(cnt));
		
		bw.flush();
		bw.close();
		br.close();
	}
}
