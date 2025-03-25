

import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static int[][] result;
    static boolean[] visited;
    static int N;

    public static void Bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        visited = new boolean[N]; // 매번 초기화
        q.offer(start);

        while (!q.isEmpty()) {
            int tmp = q.poll();
            for (int i = 0; i < N; i++) {
                if (graph[tmp][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                    result[start][i] = 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        result = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            Bfs(i);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(result[i][j] + " ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
