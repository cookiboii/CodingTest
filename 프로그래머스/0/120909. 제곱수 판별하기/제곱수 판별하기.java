class Solution {
    public int solution(int n) {
        double sqrt = Math.sqrt(n);
        if (sqrt == (int) sqrt) {
            return 1; // 제곱수인 경우
        } else {
            return 2; // 제곱수가 아닌 경우
        }
    }
}
