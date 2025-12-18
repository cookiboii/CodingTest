

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int V;
    static int count =1;
    static long depth[];
    static long visited [];
    static ArrayList<Integer> list[];
    public static void main(String[] args) throws IOException {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     StringTokenizer st =  new StringTokenizer(br.readLine());
     N = Integer.parseInt(st.nextToken());
     M = Integer.parseInt(st.nextToken());
     V = Integer.parseInt(st.nextToken());
      list = new ArrayList[N+1];
     for (int i = 1; i <= N; i++) {
         list[i]= new ArrayList<>();
     }
     for (int i = 1; i <= M; i++) {
         st =  new StringTokenizer(br.readLine());
         int x = Integer.parseInt(st.nextToken());
         int y = Integer.parseInt(st.nextToken());
         list[x].add(y);
         list[y].add(x);

     }
     visited = new long[N+1];

     for (int i = 1; i <= N; i++) {
         Collections.sort(list[i]);
     }
        depth = new long[N+1];
        Arrays.fill(depth, -1);

        depth[V] = 0;
     dfs(V,0);
     long sum = 0;
     for (int i = 1; i <= N; i++) {
         if(depth[i]!=-1){
             sum+=visited[i]*depth[i];
         }

     }
        System.out.println(sum);

    }
    public static void dfs(int node , int d){
        visited[node]=count;
        count++;
        for (int next: list[node]){
            if(depth[next]== -1){
               depth[next] = d+ 1;
               dfs(next, d+1);
            }
        }
    }


}
