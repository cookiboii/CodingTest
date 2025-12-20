

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    static int K;
    static int V;
    static int E;
    static ArrayList<Integer>[] adjList;
    static int [] colors;
    static boolean isBipartite;
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         K = Integer.parseInt(br.readLine());

        while(K-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            adjList = new ArrayList[V+1];
            isBipartite = true;
            colors = new int[V+1];

            for(int i=1;i<=V;i++){
                adjList[i] = new ArrayList<>();
            }
            for(int i=0;i<E;i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                adjList[u].add(v);
                adjList[v].add(u);
            }
            for(int i=1;i<=V;i++){
                if(!isBipartite)break;
                if(colors[i]==0){
                    dfs(i,1);

                }

            }
            if(isBipartite){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }


    }

   public static void dfs (int node,int color){
      colors[node] = color;
      for (int next: adjList[node]){
          if(colors[next]==0){
              dfs(next,-color);
          }
          else if(colors[next]==color){
              isBipartite=false;
              return;
          }
      }

    }


}
