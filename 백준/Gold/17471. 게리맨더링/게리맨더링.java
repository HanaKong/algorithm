import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] population;
    static ArrayList<Integer>[] adj;
    static boolean[] visisted;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        population = new int[N];
        adj = new ArrayList[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int adjCount = Integer.parseInt(st.nextToken());
            for (int j = 0; j < adjCount; j++) {
                int a = Integer.parseInt(st.nextToken()) - 1;
                adj[i].add(a);
                adj[a].add(i);
            }
        }

        for (int i = 1; i <= N / 2; i++) {
            boolean[] selected = new boolean[N];
            combine(0, 0, i, selected);
        }
        System.out.println(minValue == Integer.MAX_VALUE ? -1 : minValue);

        br.close();
    }

    private static void combine(int idx, int count, int targetCount, boolean[] selected) {
        if (count == targetCount) {
            checkAndCalculate(selected);
            return;
        }
        if (idx >= N) return;

        selected[idx] = true;
        combine(idx + 1, count + 1, targetCount, selected);

        selected[idx] = false;
        combine(idx + 1, count, targetCount, selected);
    }

    private static void checkAndCalculate(boolean[] selected) {
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (selected[i]) {
                A.add(i);
            } else {
                B.add(i);
            }
        }

        if (A.isEmpty() || B.isEmpty()) return;

        visisted = new boolean[N];
        if (!isConnected(A) || !isConnected(B)) return;

        int populationA = 0;
        int populationB = 0;
        for (int a : A) populationA += population[a];
        for (int b : B) populationB += population[b];

        minValue = Math.min(minValue, Math.abs(populationA - populationB));
    }

    private static boolean isConnected(List<Integer> group) {
        Queue<Integer> q = new LinkedList<>();
        q.add(group.get(0));
        visisted[group.get(0)] = true;

        int cnt = 1;
        while (!q.isEmpty()) {
            int current = q.poll();
            for (int i : adj[current]) {
                if (group.contains(i) && !visisted[i]) {
                    visisted[i] = true;
                    q.add(i);
                    cnt++;
                }
            }
        }
        return cnt == group.size();
    }
}
