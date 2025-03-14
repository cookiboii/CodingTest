

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄 입력 처리
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 배열 크기
        int K = Integer.parseInt(st.nextToken()); // 구간 합을 구할 횟수

        // 구간 합을 저장할 배열
        int[] S = new int[N + 1];

        // 두 번째 줄 입력 처리 (배열 값)
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            S[i] = S[i - 1] + Integer.parseInt(st1.nextToken());
        }

        // K개의 쿼리 처리
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) { // 정확히 K번 반복
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st3.nextToken());
            int y = Integer.parseInt(st3.nextToken());
            sb.append(S[y] - S[x - 1]).append("\n");
        }

        // 결과 출력
        System.out.print(sb);
    }
}
