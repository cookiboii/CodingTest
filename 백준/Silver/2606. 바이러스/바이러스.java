
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int infectedCount = 0;

    static void dfs(int v) {
        visited[v] = true;
        for (int next : graph[v]) {
            if (!visited[next]) {
                infectedCount++;
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int M = Integer.parseInt(br.readLine()); // 네트워크 연결 수

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a); // 양방향 연결
        }

        dfs(1); // 1번 컴퓨터부터 탐색 시작
        System.out.println(infectedCount);
    }
}
