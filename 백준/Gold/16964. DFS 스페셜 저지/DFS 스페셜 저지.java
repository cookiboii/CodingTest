

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

import java.util.StringTokenizer;

public class Main {

     static int N;

     static boolean[] visited;
     static int[] answer;
     static int[] order;
     static ArrayList<Integer> list[];
     static ArrayList<Integer> result = new ArrayList<>();

     public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       N = Integer.parseInt(br.readLine());
       list = new ArrayList[N+1];
       visited = new boolean[N+1];
       for (int i = 1; i <= N; i++) {
           list [i] = new ArrayList<>();
       }
       for (int i = 0; i < N-1; i++) {
           StringTokenizer st = new StringTokenizer(br.readLine());
           int x = Integer.parseInt(st.nextToken());
           int y = Integer.parseInt(st.nextToken());
           list [x].add(y);
           list [y].add(x);
       }
     answer = new int[N];
       order = new int[N+1];
       StringTokenizer st = new StringTokenizer(br.readLine());
       for (int i = 0; i < N; i++) {
           answer [i] = Integer.parseInt(st.nextToken());
           order [answer [i]] = i;


       }
       for (int i = 1; i <= N; i++) {
           Collections.sort(list [i], (a,b)-> order[a]-order[b]);
       }
      if (answer[0]!=1){
          System.out.println(0);
          return;
      }

      visited = new boolean[N+1];
      dfs(1);
      boolean isCorrect = true;
      for (int i = 0; i < N; i++) {
          if (result.get(i) != answer[i]) {
              isCorrect = false;
              break;
          }
      }

      System.out.println(isCorrect?1:0);
    }

    public static void dfs(int node){
        visited[node]=true;
        result.add(node);
        for(int next: list[node]){
         if(!visited[next]){
             dfs(next);
         }
        }
    }
}
