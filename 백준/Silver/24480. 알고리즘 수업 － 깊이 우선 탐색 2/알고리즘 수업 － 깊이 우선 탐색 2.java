import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main { // 백준은 클래스명이 Main이어야 합니다.
    static int N;
    static int M;
    static int V;
    static int[] visitedOrder;
    static int count = 1;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // [수정 1] st에 담긴 토큰을 꺼내야 합니다. br.readLine()을 쓰면 다음 줄로 넘어갑니다.
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        
        // 내림차순 정렬 (완벽합니다!)
        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i], Collections.reverseOrder());
        }
        
        visitedOrder = new int[N + 1];
        dfs(V);

        StringBuilder sb = new StringBuilder();
        
        // [수정 2] 1번 노드부터 N번 노드까지 출력해야 합니다. (0번 제외)
        // i < N+1 대신 i <= N 이 더 직관적입니다.
        for (int i = 1; i <= N; i++) {
            sb.append(visitedOrder[i]).append("\n");
        }
        
        // [수정 3] 모아둔 결과를 화면에 출력해야 합니다!
        System.out.println(sb);
    }

    public static void dfs(int node) {
        visitedOrder[node] = count;
        count++;
        for (int next : list[node]) {
            if (visitedOrder[next] == 0) {
                dfs(next);
            }
        }
    }
}