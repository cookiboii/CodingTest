

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int visited[];
    static ArrayList<Integer> list[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new  StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new  StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }
      visited = new int[N+1];
        Arrays.fill(visited, -1);  //방문하지않은 곳을 -1로 초기화 (거리가 0인 시작점과 구분하기위함)
       bfs(1);

       int max =0;
       int barn =0;
       int count =0;
       for (int i = 1; i <= N; i++) {
           if (visited[i] > max) {
               max = visited[i];
               barn = i;
               count = 1;
           }
           else if (visited[i] == max) {
               count++;
           }

       }
       System.out.println(barn+" "+max+" "+count);

    }

    public static void bfs (int node){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(node);
      visited[node] = 0;
        while (!q.isEmpty()){
            int x = q.poll();

            for(int i:list[x]){
                if(visited[i]==-1){
                    visited[i] = visited[x] + 1;
                    q.add(i);

                }
            }
        }
    }
}
