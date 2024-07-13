import java.util.ArrayList;

class Solution {
    static ArrayList<Integer>[] graph;
    static int min;

    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n + 1];
        min = Integer.MAX_VALUE;
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            // Remove the edge
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));
            
            // Perform DFS to count nodes in one of the resulting trees
            boolean[] visited = new boolean[n + 1];
            int cnt = dfs(v1, visited);
            
            // Calculate the difference in sizes of the two resulting trees
            int diff = Math.abs(cnt - (n - cnt));
            min = Math.min(min, diff);
            
            // Re-add the edge
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        return min;
    }

    static int dfs(int v, boolean[] visited) {
        visited[v] = true;
        int cnt = 1;
        
        for (int next : graph[v]) {
            if (!visited[next]) {
                cnt += dfs(next, visited);
            }
        }
        
        return cnt;
    }
}
