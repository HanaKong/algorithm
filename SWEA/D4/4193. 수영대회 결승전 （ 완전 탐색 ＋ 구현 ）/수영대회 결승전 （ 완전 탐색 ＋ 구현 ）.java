import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N, startR, startC, arrR, arrC, ansTime;
	static boolean result;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			st = new StringTokenizer(br.readLine());
			startR = Integer.parseInt(st.nextToken());
			startC = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			arrR = Integer.parseInt(st.nextToken());
			arrC = Integer.parseInt(st.nextToken());

			if (map[arrR][arrC] == 1)
				sb.append("#" + t + " -1" + "\n");

			else {
				BFS(startR, startC);
				if(result) sb.append("#" + t + " " + ansTime + "\n");
				else sb.append("#" + t + " -1" + "\n");
			}
		}
		System.out.println(sb);

	}

	static void BFS(int startR, int startC) {
		result = false;
		visited = new boolean[N][N];
		visited[startR][startC] = true;
		int[] start = { startR, startC, 0 }; // 시작r, 시작c, 현재시간
		Queue<int[]> que = new LinkedList<>();
		que.add(start);

		while (!que.isEmpty()) {

			int[] now = que.poll();
			int r = now[0];
			int c = now[1];
			int time = now[2];

			if (r == arrR && c == arrC) {
				result = true;
				ansTime = time;
				break;
			}

			for (int d = 0; d < 4; d++) {

				int nr = r + dr[d];
				int nc = c + dc[d];

				// 다음 위치가 그냥 물이고 아직 안가본 길이라면
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 0 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					que.add(new int[] { nr, nc, time + 1 });
				}

				// 다음 위치가 소용돌이라면 -> 시간에 따라 다르게
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 2) {

					// 다음시간이 3의 배수라면 갈 수 있음
					if ((time + 1) % 3 == 0) {
						visited[nr][nc] = true;
						que.add(new int[] { nr, nc, time + 1 });
					}
					// 다음시간이 3의 배수라면 기다리기
					else {
						que.add(new int[] { r, c, time + 1 });
					}

				}

			}

		}

	}

}
