class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int n = board.length;
        int count = 0;

        int dh[] = {0, 1, -1, 0};
        int dw[] = {1, 0, 0, -1};

        for (int i = 0; i < 4; i++) {  // 이 부분을 4로 고쳤습니다.
            int h_check = h + dh[i];
            int w_check = w + dw[i];

            // 인덱스 유효성 검사를 수정했습니다.
            if (h_check >= 0 && h_check < n && w_check >= 0 && w_check < board[h_check].length) {
                // 문자열 비교는 '==' 대신 'equals'를 사용합니다.
                if (board[h][w].equals(board[h_check][w_check])) {
                    count++;
                }
            }
        }

        answer = count;
        return answer;
    }
}
