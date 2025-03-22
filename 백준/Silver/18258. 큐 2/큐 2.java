
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if (s.equals("push")) {
                int number = Integer.parseInt(st.nextToken());
                q.add(number);
            } else if (s.equals("pop")) {
                sb.append(q.isEmpty() ? -1 : q.poll()).append("\n");
            } else if (s.equals("empty")) {
                sb.append(q.isEmpty() ? 1 : 0).append("\n");
            } else if (s.equals("size")) {
                sb.append(q.size()).append("\n");
            } else if (s.equals("front")) {
                sb.append(q.isEmpty() ? -1 : q.peek()).append("\n");
            } else if (s.equals("back")) {
                sb.append(q.isEmpty() ? -1 : ((ArrayDeque<Integer>) q).getLast()).append("\n");
            }
        }

        System.out.print(sb);
    }
}
