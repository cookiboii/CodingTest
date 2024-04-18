import java.util.*;

class Solution {
     static int count = 0;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];  //방문
        for(int i=0; i<n; i++){
            if(!visited[i]){
                
                //방문하지않으면 세준다
                answer++;
                dfs(i,computers,visited);
            }
            
        }
        
        return answer;
    }
    
    public static void dfs(int start , int [][] computers, boolean[] visited) {
        visited [start] =true;
        int [] check = computers[start];
        for(int i =0; i<check.length;i++){
            if(i ==start) continue;
            if(!visited[i] &&check[i]==1){
                dfs(i,computers,visited);
            }
            
        }
        
    }
}