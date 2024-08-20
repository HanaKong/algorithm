import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int len = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken()) - 1;

        ArrayList list = new ArrayList();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i= 0; i < len; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        System.out.println(list.get(a));
        br.close();
    }
}
