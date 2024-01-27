class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        if (a == b) {
            return a;
        } else if (a <= b) {
            for (long i = a; i <= b; i++) {
                answer = answer + i;
            }
        } else if (a >= b) {
            for (long i = b; i <= a; i++) {
                answer = answer + i;
            }
        }

        return answer;
    }
}
