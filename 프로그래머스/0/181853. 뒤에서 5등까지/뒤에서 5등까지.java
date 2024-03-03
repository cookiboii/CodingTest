import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        // 결과를 저장할 배열 선언
        int[] answer = new int[5];
        
        // 주어진 배열을 오름차순으로 정렬
        Arrays.sort(num_list);
        
        // 가장 작은 5개의 수를 answer 배열에 저장
        for (int i = 0; i < 5; i++) {
            answer[i] = num_list[i];
        }
        
        return answer;
    }
}