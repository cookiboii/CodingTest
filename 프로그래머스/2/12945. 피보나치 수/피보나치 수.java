class Solution {
    public int solution(int n) {
        int a = 0;
        int b = 1;
        int fib = 0;
        
        // n번째 피보나치 수를 구하는 반복문
        for (int i = 2; i <= n; i++) {
            fib = (a + b) % 1234567; // 나머지 연산
            a = b;
            b = fib;
        }
        
        return fib;
    }
}

