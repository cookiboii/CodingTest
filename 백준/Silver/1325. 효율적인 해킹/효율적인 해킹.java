

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] list;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // A가 B를 신뢰한다 -> B를 해킹하면 A도 해킹 가능
            // 문제: "한 번에 가장 많은 컴퓨터를 해킹"
            // B -> A 방향으로 탐색해야 함. 따라서 list[b].add(a)가 맞음.
            list[b].add(a);
        }

        result = new int[N + 1];
        int maxVal = 0;

        // 모든 노드에 대해 BFS 수행
        for (int i = 1; i <= N; i++) {
            // BFS를 통해 i번 컴퓨터를 해킹했을 때 감염되는 수 리턴
            int count = bfs(i);
            result[i] = count;
            maxVal = Math.max(maxVal, count);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (result[i] == maxVal) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    // DFS 대신 BFS 사용 (재귀 오버헤드 제거)
    public static int bfs(int startNode) {
        // 방문 배열을 여기서 생성 (어쩔 수 없는 부분이나, boolean 배열은 생성이 빠름)
        boolean[] visited = new boolean[N + 1];
        // LinkedList보다 ArrayDeque가 큐 연산 속도가 더 빠름
        Queue<Integer> q = new ArrayDeque<>();
        
        q.add(startNode);
        visited[startNode] = true;
        
        int count = 0;
        
        while (!q.isEmpty()) {
            int current = q.poll();
            // 큐에서 뺄 때가 아니라 넣을 때 카운트하거나, 뺄 때 카운트해도 됨.
            // 여기서는 뺄 때마다 카운트 하지 않고, 연결된 노드를 찾을 때마다 증가시켜도 됨.
            // 단순히 방문한 노드 개수를 세는 로직:
            
            for (int next : list[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    count++; // 연결된 노드 하나 추가
                }
            }
        }
        return count;
    }
}