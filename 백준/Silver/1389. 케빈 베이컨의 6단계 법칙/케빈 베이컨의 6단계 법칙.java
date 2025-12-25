

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int dist[];
    static ArrayList<Integer> list[];
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
          list = new ArrayList[N+1];
          dist = new int[N];
        int minBacon = Integer.MAX_VALUE;
        int answerPerson =0;
          for (int i = 1; i <= N; i++) {
              list[i] = new ArrayList<>();
          }
          for (int i = 1; i <= M; i++) {
              st = new StringTokenizer(br.readLine());
              int x = Integer.parseInt(st.nextToken());
              int y = Integer.parseInt(st.nextToken());
              list[x].add(y);
              list[y].add(x);
          }
        for (int i = 1; i <=N; i++) {
            int currentBacon = bfs(i);
           if (currentBacon < minBacon) {
               minBacon = currentBacon;
               answerPerson = i;
           }
        }
     System.out.println(answerPerson);

    }

    public static int bfs (int node){
        Queue<Integer> queue = new ArrayDeque<>();
         dist = new int[N+1];
        Arrays.fill(dist,-1);
        queue.add(node);

       dist[node] = 0;
        int sum =0;
        while (!queue.isEmpty()){
            int x = queue.poll();
            for(int i:list[x]){
                if(dist[i]==-1){
                    dist[i] = dist[x]+1;
                    sum+=dist[x];
                    queue.add(i);
                }
            }
        }

        return sum;
    }
}
