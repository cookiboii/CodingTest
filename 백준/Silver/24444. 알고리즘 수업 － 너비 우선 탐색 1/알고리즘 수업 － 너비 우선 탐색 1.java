

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int V;
    static ArrayList<Integer> list [];
    static  int visited [];
    static  int count =1;
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      V = Integer.parseInt(st.nextToken());
      list = new ArrayList[N+1];
      for (int i = 1; i <= N; i++) {
         list[i] = new ArrayList<>();
      }
      for (int i = 0; i < M; i++) {
          st = new StringTokenizer(br.readLine());
          int a = Integer.parseInt(st.nextToken());
          int b = Integer.parseInt(st.nextToken());
          list[a].add(b);
          list[b].add(a);

      }
      for (int i = 1; i <= N; i++) {
          Collections.sort(list[i]);
      }
       visited = new int[N+1];
       bfs(V);
       StringBuilder sb = new StringBuilder();
       for (int i = 1; i <= N; i++) {
           sb.append(visited[i]).append("\n");
       }
       System.out.println(sb);
    }
    public static void bfs(int node) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(node);
         visited[node] = count++;

        while (!q.isEmpty()) {
           int u = q.poll();
           for (int v: list[u]) {
               if (visited[v] == 0) {
                   visited[v] = count++;
                   q.add(v);
               }
           }

        }

    }
}
