

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int [][] dist ={{1,0}, {-1,0}, {0,1}, {0,-1}};
    public static void bfs(int map [][],int start, int end ,int h) {
       Queue<int[]> q = new ArrayDeque<>();
       q.offer(new int[]{start,end});
       visited[start][end] = true;

       while(!q.isEmpty()) {
           int[] cur = q.poll();
           int x = cur[0],y = cur[1];

           for (int dir[] : dist) {
                 int nx = x + dir[0],ny = y + dir[1];
                 if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
             if(!visited[nx][ny] && map[nx][ny] > h ) {
                 visited[nx][ny] = true;

                 q.offer(new int[]{nx,ny});
             }


           }
       }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        int max_height = 0;
        for (int i = 0; i <N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <N ; j++) {
               map[i][j] =Integer.parseInt(st.nextToken());
              max_height= Math.max(max_height,map[i][j]);
            }

        }
        int max_safe_area = 0;
        for (int h = 0; h <= max_height; h++) {
            visited = new boolean[N][N];
            int safe_area = 0;
            for (int i = 0; i <N ; i++) {
                for (int j = 0; j <N ; j++) {
                     if(!visited[i][j]&&map[i][j]>h) {
                         bfs(map,i,j,h);
                         safe_area++;
                     }
                }

            }
            max_safe_area = Math.max(max_safe_area,safe_area);
        }
        System.out.println(max_safe_area);
    }
}