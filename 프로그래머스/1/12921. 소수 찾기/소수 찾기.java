class Solution {
    public int solution(int n) {
        int answer = 0;
        
        boolean[] primes = new boolean[n+1]; // 소수 여부를 저장하는 배열
        
        // 초기화: 모든 수를 소수로 가정
        for (int i = 2; i <= n; i++) {
            primes[i] = true;
        }
        
        // 에라토스테네스의 체를 이용하여 소수 찾기
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false; // i의 배수는 소수가 아님
                }
            }
        }
        
        // 소수의 개수 세기
        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                answer++;
            }
        }
        
        return answer;
    }
}
