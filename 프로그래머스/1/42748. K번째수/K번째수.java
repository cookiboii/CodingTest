import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
      
          int[] answer = new int[commands.length];

        // commands 배열을 순회하며 각각의 조건에 맞게 처리
        for (int i = 0; i < commands.length; i++) {
            int[] cmd = commands[i];
            int startIdx = cmd[0] - 1;
            int endIdx = cmd[1];
            int k = cmd[2];

            // 배열을 자르고 정렬
            int[] slicedArray = Arrays.copyOfRange(array, startIdx, endIdx);
            Arrays.sort(slicedArray);
            
            // k번째 숫자를 answer에 추가
            answer[i] = slicedArray[k - 1];
        }

        
        return answer;
    }
}