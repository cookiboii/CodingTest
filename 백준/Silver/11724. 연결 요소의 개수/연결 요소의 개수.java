

import java.io.*;
import java.util.*;

public class Main {

        static int N;
        static int M;
    static int[][] graph;
        static boolean[] visited;
       public static void bfs(int node){
           Queue<Integer> q = new ArrayDeque<>();
           q.offer(node);  //노드값을 집어 넣었는다
            while(!q.isEmpty()){  // 큐가 비어있지않으면
                int cur = q.poll();  //꺼낸다
                visited[cur] = true;  //꺼낸 값은 참이다
                for (int i = 1; i <=N ; i++) {
                    if(!visited[i] && graph[cur][i] == 1){  //방문하지않고 그래프 값이 1인곳은
                        q.offer(i);   //i값을 집어넣은다
                       visited[i] = true; //그값은 참이다
                    }

                }
            }

       }






    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N+1][N+1];
        visited = new boolean[N+1];
        for(int  i =0 ;i < M ;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] =graph[y][x]= 1;
        }

      int count =0;
        for(int i =1 ;i <= N ;i++){
            if(!visited[i]){
                bfs(i);
                count++;
            }
        }
        System.out.println(count);

    }

}
