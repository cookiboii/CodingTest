

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            N=Integer.parseInt(br.readLine());
            int [] map =new int[N+1];
            boolean[] visited=new boolean[N+1];
            int count=0;
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int i=1;i<=N;i++){
                map[i]=Integer.parseInt(st.nextToken());
            }

            for(int i=1;i<=N;i++){
                if(!visited[i]){
                    dfs(i,map,visited);
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static void dfs(int node,int [] map,boolean[] visited){
      visited[node]=true;
      int next = map[node];
      if(!visited[next]){
          dfs(next,map,visited);
      }

    }
}
