import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // n 입력 받기
        int n = Integer.parseInt(br.readLine());
        
        // DP 테이블 생성 (n은 최대 1000이므로 1001 크기로 잡음)
        int[] dp = new int[1001];
        
        // 초기값 세팅 (Base Case)
        dp[1] = 1;
        if (n >= 2) { // n이 1일 수도 있으므로 예외 처리
            dp[2] = 3;
        }
        
        // 점화식 적용 (Bottom-Up 방식)
        for (int i = 3; i <= n; i++) {
            // 점화식: dp[i] = dp[i-1] + 2 * dp[i-2]
            // 문제 조건에 따라 10007로 나눈 나머지 저장
            dp[i] = (dp[i-1] + 2 * dp[i-2]) % 10007;
        }
        
        System.out.println(dp[n]);
    }
}