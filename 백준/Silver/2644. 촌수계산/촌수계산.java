

import java.io.*;
import java.util.*;

public class Main {

    static class NodeInfo {
        int index, count;

        public NodeInfo(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    static int answer = -1;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int N, M;
    static boolean[] visited;

    public static void bfs(int start, int end) {
        Queue<NodeInfo> q = new ArrayDeque<>();
        visited = new boolean[N + 1];

        visited[start] = true;
        q.add(new NodeInfo(start, 0));

        while (!q.isEmpty()) {
            NodeInfo current = q.poll();

            if (current.index == end) {
                answer = current.count;
                return;
            }

            for (int next : graph.get(current.index)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new NodeInfo(next, current.count + 1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int S = Integer.parseInt(br.readLine());
        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
            graph.get(B).add(A);
        }

        bfs(M, K);
        System.out.println(answer);
    }
}
