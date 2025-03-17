import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new ArrayDeque<>();

        // 1부터 N까지 큐에 추가
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        // 카드 제거 로직 (Queue 활용)
        while (q.size() > 1) {
            q.poll(); // 맨 위 카드 제거
            q.offer(q.poll()); // 다음 카드를 뒤로 이동
        }

        // 마지막 남은 카드 출력
        System.out.println(q.poll());
    }
}
