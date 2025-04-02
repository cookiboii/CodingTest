

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static boolean[][] visited;
    static int [][] dist ={{1,0}, {-1,0}, {0,1}, {0,-1}};

    public static int bfs(int [][]map ,int  start, int end){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{start, end});
        visited[start][end] = true;
        int cnt = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int[] dir : dist) {
                int newx = x + dir[0];
                int newy = y + dir[1];

                if (newx < 0 || newx >= N || newy < 0 || newy >= M) {
                    continue;
                }
                if (visited[newx][newy] || map[newx][newy] != 0) {
                    continue;
                }

                visited[newx][newy] = true;
                map[newx][newy] = cnt;
                cnt++;
                q.offer(new int[]{newx, newy});
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        visited = new boolean[N][M];

        int K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    map[y][x] = 1;
                }
            }
        }

        List<Integer> areas = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    areas.add(bfs(map, i, j));
                }
            }
        }

        Collections.sort(areas);
        System.out.println(areas.size());
        for (int area : areas) {
            System.out.print(area + " ");
        }
    }
}