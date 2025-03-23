
import java.io.*;
import java.util.*;

public class Main {
    static int [][] dirs ={{1,0},{-1,0},{0,1},{0,-1}};
    static int N, M, K, count;
    static boolean[][] visited;
    static int [][] cabbage;

    public static void Bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];
            for (int[] dir : dirs) {
                int nx = cx + dir[0], ny = cy + dir[1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (cabbage[nx][ny] == 1 && !visited[nx][ny]) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            cabbage = new int[N][M];
            visited = new boolean[N][M];
            count = 0;

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int p1 = Integer.parseInt(st.nextToken());
                int p2 = Integer.parseInt(st.nextToken());
                cabbage[p2][p1] = 1;  // 행과 열 반대로 저장
            }

            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (cabbage[x][y] == 1 && !visited[x][y]) {
                        Bfs(x, y);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}
