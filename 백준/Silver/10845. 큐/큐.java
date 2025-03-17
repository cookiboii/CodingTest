

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 명령어 개수
        Queue<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            if (command.equals("push")) {
                int number = Integer.parseInt(st.nextToken());
                q.add(number);
            }
            else if (command.equals("pop")) {
                sb.append(q.isEmpty() ? -1 : q.poll()).append("\n");
            }
            else if (command.equals("size")) {
                sb.append(q.size()).append("\n");
            }
            else if (command.equals("empty")) {
                sb.append(q.isEmpty() ? 1 : 0).append("\n");
            }
            else if (command.equals("front")) {
                sb.append(q.isEmpty() ? -1 : q.peek()).append("\n");
            }
            else if (command.equals("back")) {
                sb.append(q.isEmpty() ? -1 : ((ArrayDeque<Integer>) q).getLast()).append("\n");
            }
        }
        System.out.print(sb);
    }
}
