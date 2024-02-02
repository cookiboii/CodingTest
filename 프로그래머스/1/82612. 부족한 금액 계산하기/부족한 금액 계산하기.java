class Solution {
    public long solution(int price, long money, int count) {
        long beforeanswer = 0;
        long sum = 0;

        for (long i = 1; i <= count; i++) {
            sum = sum + price * i;
        }

        if (sum > money) {
            beforeanswer = sum - money;
            Long answer = Long.valueOf(beforeanswer);
            return answer;
        } else {
            return 0;
        }
    }
}