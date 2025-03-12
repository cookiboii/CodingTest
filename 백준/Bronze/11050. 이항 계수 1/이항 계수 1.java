import java.io.*;

public class Main {
    static final int MOD = 10007;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        // DP 테이블 초기화
        dp = new int[N + 1][K + 1];

        // 조합 DP 계산
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= Math.min(i, K); j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1; // Base Case: nC0 = 1, nCn = 1
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
                }
            }
        }

        // 결과 출력
        System.out.println(dp[N][K]);
    }
}
