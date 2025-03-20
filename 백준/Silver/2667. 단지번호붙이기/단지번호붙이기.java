
import java.io.*;
import java.util.*;

public class Main {
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 상하좌우 이동
    static boolean[][] visited;
    static int N;

    public static int Bfs(int[][] map, int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true; // 시작점 방문 처리

        int count = 1; // 현재 단지의 집 개수

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];

            for (int[] dir : dirs) {
                int nx = cx + dir[0], ny = cy + dir[1];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue; // 범위 체크
                if (map[nx][ny] == 0 || visited[nx][ny]) continue; // 벽이거나 이미 방문한 경우 스킵

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
                count++;
            }
        }
        return count; // 단지 크기 반환
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        visited = new boolean[N][N]; // 방문 배열 초기화

        // 입력값 처리 (0: 벽, 1: 집)
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        List<Integer> complexes = new ArrayList<>();
        int complexCount = 0;

        // 모든 위치 탐색하여 단지 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    complexes.add(Bfs(map, i, j)); // 단지 크기 구하기
                    complexCount++;
                }
            }
        }

        Collections.sort(complexes); // 단지 크기 오름차순 정렬
        System.out.println(complexCount);
        for (int size : complexes) {
            System.out.println(size);
        }
    }
}
