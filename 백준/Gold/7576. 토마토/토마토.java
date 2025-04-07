
import java.io.*;
import java.util.*;

public class Main {
    static int[][] dirs = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} }; // 4방향
    static int N;
    static int M;
    static int[][] days;
    static int[][] tomato;
    static Queue<int[]> queue = new ArrayDeque<>(); // ✅ BFS Queue를 static으로!

    public static void bfs() {
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int cx = arr[0];
            int cy = arr[1];

            for (int i = 0; i < dirs.length; i++) {
                int nx = cx + dirs[i][0];
                int ny = cy + dirs[i][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (tomato[nx][ny] == 0) {
                    tomato[nx][ny] = 1; // 토마토 익히기
                    days[nx][ny] = days[cx][cy] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomato = new int[N][M];
        days = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) { // ✅ 초기 익은 토마토들 모두 큐에 넣기
                    queue.offer(new int[]{i, j});
                }
            }
        }

        bfs(); // BFS 시작

        int max_day = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomato[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                max_day = Math.max(max_day, days[i][j]);
            }
        }

        System.out.println(max_day);
    }
}
