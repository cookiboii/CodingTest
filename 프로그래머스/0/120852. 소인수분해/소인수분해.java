class Solution {
    public int[] solution(int n) {
        int[] result = new int[10000]; // 충분히 큰 배열을 할당하여 사용
        int index = 0;
        index = findPrimeFactors(n, 2, result, index);

        // 결과 배열에서 실제 크기만큼 잘라내기
        int[] answer = new int[index];
        for (int i = 0; i < index; i++) {
            answer[i] = result[i];
        }
        
        return answer;
    }

    private int findPrimeFactors(int n, int divisor, int[] result, int index) {
        if (n < divisor) {
            return index; // 기저 조건
        }

        if (n % divisor == 0) {
            // 중복된 소인수는 추가하지 않기 위해 이전에 추가된 소인수와 비교
            if (index == 0 || result[index - 1] != divisor) {
                result[index++] = divisor;
            }
            return findPrimeFactors(n / divisor, divisor, result, index); // 나눈 몫으로 재귀 호출
        } else {
            return findPrimeFactors(n, divisor + 1, result, index); // 나누어 떨어지지 않으면 다음 수로 진행
        }
    }
}
