class Solution {
    int solution(int[][] land) {
        int answer = Integer.MIN_VALUE;
        int n = land.length;
        int[][] dp = new int[n][land[0].length];
        
        // 첫 번째 행의 초기값 설정
        for(int i = 0; i < land[0].length; i++) {
            dp[0][i] = land[0][i];
        }
        
        // 두 번째 행부터 마지막 행까지 dp 배열 채우기
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < land[i].length; j++) {
                int max = Integer.MIN_VALUE;
                // 현재 열을 제외한 이전 행의 최대값 찾기
                for(int k = 0; k < 4; k++) {
                    if(j == k) continue;
                    max = Math.max(max, dp[i - 1][k]);
                }
                // 현재 위치의 최대값 계산하여 dp 배열에 저장
                dp[i][j] = land[i][j] + max;
            }
        }
        
        // 마지막 행에서의 최대값 찾기
        for(int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[n - 1][i]);
        }
        
        return answer;
    }
}
