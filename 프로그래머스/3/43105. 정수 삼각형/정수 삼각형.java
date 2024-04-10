class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int height = triangle.length;

        // 다이내믹 프로그래밍을 위한 2차원 배열 초기화
        int[][] dp = new int[height][height];
        dp[0][0] = triangle[0][0]; // 삼각형의 꼭대기 값 초기화

        // 각 층의 첫 번째와 마지막 값은 대각선 방향으로만 이동 가능
        for (int i = 1; i < height; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0]; // 왼쪽 끝 값
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i]; // 오른쪽 끝 값
        }

        // 나머지 위치에 대해 최대 합 계산
        for (int i = 2; i < height; i++) {
            for (int j = 1; j < i; j++) {
                // 이전 층에서 대각선 방향으로 오른쪽 또는 왼쪽으로 이동할 수 있으므로, 둘 중 최대값을 선택
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
        }

        // 마지막 층에 저장된 값들 중 최댓값을 반환
        for (int i = 0; i < height; i++) {
            answer = Math.max(answer, dp[height - 1][i]);
        }

        return answer;
    }
}
