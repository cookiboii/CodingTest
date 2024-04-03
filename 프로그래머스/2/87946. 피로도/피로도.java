class Solution {
    boolean[] visit;
    int[][] dungeons;
    int max = 0;

    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        visit = new boolean[dungeons.length];
        for (int i = 0; i < dungeons.length; i++) {
            if (k >= dungeons[i][0]) {
                dfs(i, k, 1);
            }
        }

        return max;
    }

    private void dfs(int cur, int tired, int depth) {
        visit[cur] = true;  // 현재 던전을 방문했음을 표시합니다.
        tired -= dungeons[cur][1];  // 현재 던전을 탐험하고 남은 피로도를 계산합니다.
        for (int i = 0; i < dungeons.length; i++) {
            if (!visit[i] && dungeons[i][0] <= tired) {  // 아직 방문하지 않은 이웃 던전이면서 피로도가 충분한 경우
                dfs(i, tired, depth + 1);  // 이웃 던전을 탐험합니다.
            }
        }
        visit[cur] = false;  // 백트래킹: 현재 던전을 다시 방문할 수 있도록 방문 여부를 초기화합니다.
        max = Math.max(depth, max);  // 현재까지의 최대 탐험 횟수를 갱신합니다.
    }
}
