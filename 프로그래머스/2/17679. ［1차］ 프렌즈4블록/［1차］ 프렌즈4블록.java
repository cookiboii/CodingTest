import java.util.*;

class Solution {
    private static char[][] blockMap;

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        // 초기 블록 맵을 설정
        blockMap = new char[m][n];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length(); col++) {
                blockMap[row][col] = board[row].charAt(col);
            }
        }
        
        // 블록을 반복해서 제거하고 떨어뜨림
        while (true) {
            boolean[][] isSame = new boolean[m][n];
            checkBlock(m, n, isSame);
            int count = countBlock(m, n, isSame);
            if (count == 0) {
                break;
            }
            answer += count;
            dropBlock(m, n);
        }
        
        return answer;
    }
    
    // 블록을 아래로 떨어뜨리는 함수
    private static void dropBlock(int m, int n) {
        for (int row = m - 1; row >= 0; row--) {
            for (int col = 0; col < n; col++) {
                if (blockMap[row][col] != '-') {
                    continue;
                }
                // 빈칸인 경우 위에 있는 블록을 찾아 아래로 내림
                for (int k = row - 1; k >= 0; k--) {
                    if (blockMap[k][col] != '-') {
                        blockMap[row][col] = blockMap[k][col];
                        blockMap[k][col] = '-';
                        break;
                    }
                }
            }
        }
    }
    
    // 2x2 블록을 찾는 함수
    public static void checkBlock(int m, int n, boolean[][] isSame) {
        for (int row = 0; row < m - 1; row++) {
            for (int col = 0; col < n - 1; col++) {
                char block = blockMap[row][col];
                // 블록이 모두 동일한지 확인
                if (block != '-' && block == blockMap[row + 1][col] && block == blockMap[row][col + 1] && block == blockMap[row + 1][col + 1]) {
                    isSame[row][col] = true;
                    isSame[row + 1][col] = true;
                    isSame[row][col + 1] = true;
                    isSame[row + 1][col + 1] = true;
                }
            }
        }
    }
    
    // 제거할 블록의 개수를 세는 함수
    public static int countBlock(int m, int n, boolean[][] isSame) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isSame[i][j] && blockMap[i][j] != '-') {
                    count++;
                    blockMap[i][j] = '-';
                }
            }
        }
        return count;
    }
}
