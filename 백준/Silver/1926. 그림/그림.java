

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int N, M;
    static boolean[][] visited;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int bfs(int[][] map, int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        int count = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];

            for (int[] dir : dirs) {
                int nx = cx + dir[0], ny = cy + dir[1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (map[nx][ny] == 0 || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        N = Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);
        int[][] map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        int count = 0;      // 연결된 1의 덩어리 개수
        int LargeArea = 0;  // 가장 큰 영역 크기

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int area = bfs(map, i, j);
                    LargeArea = Math.max(LargeArea, area);
                    count++; // 새로운 덩어리 발견하면 증가
                }
            }
        }

        System.out.println(count);    // 1 덩어리 개수 출력
        System.out.println(LargeArea); // 가장 큰 덩어리 크기 출력
    }
}
