import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[][] patterns = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        int[] scores = new int[3];
        
        // 각 수포자의 패턴과 정답을 비교하여 점수 계산
        for (int idx = 0; idx < answers.length; idx++) {
            for (int i = 0; i < 3; i++) {
                if (answers[idx] == patterns[i][idx % patterns[i].length]) {
                    scores[i]++;
                }
            }
        }
        
        // 가장 높은 점수를 받은 수포자 찾기
        int maxScore = Math.max(Math.max(scores[0], scores[1]), scores[2]);
        
        // 가장 높은 점수를 받은 수포자들을 리스트에 추가
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (scores[i] == maxScore) {
                resultList.add(i + 1);
            }
        }
        
        // 리스트를 배열로 변환
        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }
        
        return result;
    }
}
