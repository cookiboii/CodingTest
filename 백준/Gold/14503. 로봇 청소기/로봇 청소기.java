

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    static int N, M;
    static int[][] map; // 0: 빈칸, 1: 벽
    static int count = 0;
    // 청소한 칸 개수
    // 북, 동, 남, 서 (문제에서 준 순서대로!)
    // 0:북, 1:동, 2:남, 3:서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {

         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        map = new int [N] [M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        clean(r, c, d);
        System.out.println(count);
    }

    public static void clean(int x, int y, int dir) {
          if (map[x][y] == 0) {
              map[x][y] = 2;
              count++;
          }
         for (int i = 0; i < 4; i++) {
             dir = (dir+3)%4;
             int nx = x + dx[dir];
             int ny = y + dy[dir];

             if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                 if (map[nx][ny] == 0) {
                     clean(nx,ny,dir);
                     return;
                 }
             }
         }
        int backDir = (dir+2)%4;
        int bx =x + dx[backDir];
        int by = y + dy[backDir];
        if (bx >= 0 && bx < N && by >= 0 && by < M && map[bx][by] != 1) {
            clean(bx,by,dir);
        }
    }
}
