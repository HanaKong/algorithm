import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            pq.offer(num);
        }
        int num1 = 0;
        int num2 = 0;
        int res = 0;

        while(pq.size() != 1){
            num1 = pq.poll();
            num2 = pq.poll();
            res += num1 + num2;
            pq.offer(num1 + num2);
        }
        System.out.println(res);

        sc.close();
    }
}
