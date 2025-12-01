


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    static int N;
    static int [ ] parents;
    static boolean visited[];
    static ArrayList<Integer> [] list;
    public static  void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N  = Integer.parseInt(br.readLine());
      parents = new int[N+1];
      visited = new boolean[N+1];
      list = new ArrayList[N+1];

      for (int i = 1; i <= N; i++) {
          list[i] = new ArrayList<>();
      }
     for (int i = 0; i < N-1; i++) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         int a = Integer.parseInt(st.nextToken());
         int b = Integer.parseInt(st.nextToken());
         list[a].add(b);
         list[b].add(a);
     }
     dfs(1);
      for (int i = 2; i <= N; i++) {
          System.out.println(parents[i]);
      }
    }
    public static void dfs(int v) {

        visited[v] = true;
        for ( int next: list[v] ) {
            if (!visited[next]) {

                parents[next] = v;

                dfs(next);

            }
        }


    }

}
