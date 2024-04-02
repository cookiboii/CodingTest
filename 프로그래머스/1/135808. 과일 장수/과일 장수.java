import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        // 입력된 score 배열을 오름차순으로 정렬
        Arrays.sort(score);

        // 가장 낮은 점수부터 m개씩 묶어서 상자를 만들어 이익을 계산
        for (int i = score.length; i >= m; i -= m) {
            answer += score[i - m] * m;
        }

        return answer; // 계산된 이익 반환
    }
}
