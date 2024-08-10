class Solution {
    public int solution(int[] num_list) {
        int answer = 0;

        // 배열의 각 숫자에 대해 연산 횟수를 구해 더합니다.
        for (int num : num_list) {
            answer += count(num);
        }

        return answer;
    }

    // num을 1로 만들기 위한 연산 횟수를 재귀적으로 구하는 함수
    private int count(int num) {
        if (num == 1) {
            return 0; // num이 1이면 더 이상 연산이 필요 없습니다.
        }
        if (num % 2 == 0) {
            return 1 + count(num / 2); // 짝수일 경우 반으로 나눕니다.
        } else {
            return 1 + count((num - 1) / 2); // 홀수일 경우 1을 뺀 후 반으로 나눕니다.
        }
    }
}
