

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point1 {
    int x, y;
    Point1(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;

    // 상하좌우 이동용 배열 (필수!)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i <N ; i++) {

            String line = br.readLine();
            for (int j = 0 ; j < N ; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        visited = new boolean[N][N];
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < N ; j++) {
              if(!visited[i][j] && map[i][j]==1) {
                  int count = bfs(i,j);
                  result.add(count);

              }
            }
        }
        Collections.sort(result);

        System.out.println(result.size()); // 총 단지 수
        for (int c : result) {
            System.out.println(c); // 각 단지내 집의 수
        }

    }
    public static int bfs(int x, int y) {
        Queue<Point1> queue = new ArrayDeque<>();
        queue.add(new Point1(x, y));

        visited[x][y] = true;
        int houseCount = 1; // 시작점도 집이니까 1개로 시작
        while (!queue.isEmpty()) {
            Point1 point = queue.poll();
          for (int i = 0; i < 4; i++) {
                int x1 = point.x + dx[i];
                int y1 = point.y + dy[i];
                if (x1 <0 || x1 >= N || y1 <0 ||y1 >= N) {
                    continue;
                }
                if (map[x1][y1]==0||visited[x1][y1] ) {
                    continue;
                }
                queue.add(new Point1(x1, y1));
                visited[x1][y1] = true;
                houseCount++;
          }
        }
        return houseCount;
    }

}
