
import java.io.*;
import java.util.*;

public class Main {
    static int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}}; //상하 좌우로 이동할떄 이렇게 한다 

    public static int Bfs(int[][] map, int N, int M) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});

        boolean[][] visited = new boolean[N][M]; // 방문 여부 체크
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            // 도착지점에 도달하면 해당 위치의 거리 반환
            if (x == N - 1 && y == M - 1) {
                return map[x][y];
            }

            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue; // 범위 체크
                if (map[nx][ny] == 0 || visited[nx][ny]) continue; // 벽이거나 방문한 경우 스킵

                visited[nx][ny] = true;
                map[nx][ny] = map[x][y] + 1; // 현재까지 거리 +1
                q.offer(new int[]{nx, ny});
            }
        }
        return -1; // 도착할 수 없는 경우
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        // 입력값 처리 (0: 벽, 1: 길)
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int result = Bfs(map, N, M);
        System.out.println(result);
    }
}
