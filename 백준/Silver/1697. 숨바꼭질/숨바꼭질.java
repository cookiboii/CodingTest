import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] dist = new int[100001]; // 이동 횟수를 저장할 배열 (최대 범위)

    public static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        dist[start] = 0; // 시작 위치의 이동 횟수는 0

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            // 동생 위치에 도착하면 최단 거리 반환
            if (cur == K) return dist[cur];

            // 이동 가능한 위치 (X - 1, X + 1, X * 2)
            int[] nextPositions = {cur - 1, cur + 1, cur * 2};

            for (int next : nextPositions) {
                // 범위 체크 (0 ~ 100000) & 방문하지 않은 곳만 탐색
                if (next >= 0 && next <= 100000 && dist[next] == -1) {
                    dist[next] = dist[cur] + 1; // 이동 횟수 저장
                    queue.offer(next); // 큐에 추가
                }
            }
        }
        return -1; // 도달 불가능한 경우 (문제 조건상 존재하지 않음)
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 수빈이 위치
        K = Integer.parseInt(st.nextToken()); // 동생 위치

        Arrays.fill(dist, -1); // 방문 여부를 -1로 초기화
        System.out.println(bfs(N)); // 최단 이동 횟수 출력
    }
}
