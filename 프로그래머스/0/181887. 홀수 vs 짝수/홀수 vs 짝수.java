class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int odd_sum = 0;
        int even_sum = 0;
        
        // 배열의 길이만큼 반복하면서 홀수 번째와 짝수 번째 원소의 합을 구함
        for (int i = 0; i < num_list.length; i++) {
            if (i % 2 == 0) {
                odd_sum += num_list[i];
            } else {
                even_sum += num_list[i];
            }
        }
        
        // 홀수 번째와 짝수 번째 원소의 합 중 큰 값을 answer에 저장
        if (odd_sum >= even_sum) {
            answer = odd_sum;
        } else {
            answer = even_sum;
        }
        
        return answer;
    }
}
