class Solution {
    public int solution(int i, int j, int k) {
        // 결과 값을 저장할 변수 초기화
        int result = 0;

        // i부터 j까지 반복
        for (; i <= j; i++) {
            // 현재 숫자 i를 n에 저장
            int n = i;
            
            // n의 각 자리 숫자를 확인
            while (n > 0) {
                // n의 마지막 자리가 k와 같은지 확인
                if (n % 10 == k) {
                    // 같다면 결과 값을 1 증가
                    result++;
                }
                // n을 10으로 나눠 다음 자리 숫자를 확인
                n /= 10;
            }
        }
        
        // 최종 결과 값을 반환
        return result;
    }
}