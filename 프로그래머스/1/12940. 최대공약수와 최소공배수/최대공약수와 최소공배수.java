public class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int gcdResult = gcd(n, m);
        answer[0] = gcdResult;

        // Calculate the least common multiple (LCM)
        int lcm = n * m / gcdResult;
        answer[1] = lcm;

        return answer;
    }

    public int gcd(int x, int y) {
        while (y != 0) {
            int temp = x;
            x = y;
            y = temp % y;
        }
        return x;
    }
}
