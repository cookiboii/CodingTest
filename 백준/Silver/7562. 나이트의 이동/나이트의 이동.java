

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static boolean[][] visited;  // 방문배열
    static int[][] dist;  // 이동 거리 저장
    static int[][] moves = {{-2,-1}, {-2,1}, {-1,2}, {-1,-2},{1,2},{1,-2},{2,-1},{2,1}}; // 나이트 이동 방향

    public static int bfs(int sx, int sy, int ex, int ey) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy});
        visited[sx][sy] = true;
        dist[sx][sy] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if (x == ex && y == ey) {  // 목표 위치 도착
                return dist[x][y];
            }

            for (int[] move : moves) {
                int newx = x + move[0];
                int newy = y + move[1];

                if (newx >= 0 && newx < N && newy >= 0 && newy < N) { // 체스판 범위 체크
                    if (!visited[newx][newy]) {  // 방문하지 않은 곳만 탐색
                        visited[newx][newy] = true;
                        dist[newx][newy] = dist[x][y] + 1;
                        q.offer(new int[]{newx, newy});
                    }
                }
            }
        }

        return -1; // 도달할 수 없는 경우 (문제 조건상 발생하지 않음)
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N][N];
            dist = new int[N][N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            sb.append(bfs(sx, sy, ex, ey)).append("\n");
        }

        System.out.print(sb); // 루프가 끝난 후 한 번만 출력
    }
}
