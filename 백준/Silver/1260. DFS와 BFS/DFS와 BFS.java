

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
     static int N;
     static int M;
     static int V;
    static boolean[] visited; // 방문 체크
    static StringBuilder sb = new StringBuilder(); // 출력을 모아서 하기 위함
     static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
         V = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for (int i = 1; i <=N ; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <=M ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);


        }
        for (int i = 1; i <=N ; i++) {
            Collections.sort(list[i]);
        }
        visited = new boolean[N+1];
        dfs(V);
        sb.append("\n");
        visited = new boolean[N+1];
        bfs(V);

        System.out.println(sb);
    }

    public static void dfs(int node){
        visited[node] = true;
        sb.append(node).append(" ");

        for(int next: list[node]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }

    public static void bfs(int start){
       Queue<Integer> q = new LinkedList<>();
       q.add(start);
       visited[start] = true;
       while(!q.isEmpty()){
           int v =q.poll();
           sb.append(v).append(" ");
           for(int next: list[v]){
               if(!visited[next]){
                   q.add(next);
                   visited[next] = true;
               }
           }
       }

    }
}
