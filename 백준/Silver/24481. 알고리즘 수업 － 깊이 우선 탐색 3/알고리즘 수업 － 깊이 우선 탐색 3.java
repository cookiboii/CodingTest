

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int  N;
    static int U;
    static int V;

    static int depth [];
    static ArrayList<Integer> list[];
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      U = Integer.parseInt(st.nextToken());
      V = Integer.parseInt(st.nextToken());
      list = new ArrayList[N+1];
    for (int i = 1; i <= N; i++) {
        list[i] = new ArrayList<>();
    }
   for (int i = 1; i <= U; i++) {
       st = new StringTokenizer(br.readLine());
         int a = Integer.parseInt(st.nextToken());
         int b = Integer.parseInt(st.nextToken());
         list[a].add(b);
         list[b].add(a);

   }
     for (int i = 1; i <= N; i++) {
         Collections.sort(list[i]);
     }
     depth = new int [N+1];
     Arrays.fill(depth, -1);
     depth[V]=0;
     dfs(V,0);

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= N; i++) {
        sb.append(depth[i]).append('\n');
    }
    System.out.println(sb);

    }

    public static  void  dfs (int node , int d){
      for (int next: list[node]) {
          if(depth [next]== -1){
            depth [next] = d+1;
            dfs(next,d+1);
          }
      }
    }

}
