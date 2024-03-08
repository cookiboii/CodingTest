public class Solution {
    public int solution(int a, int b) {
        String abString = Integer.toString(a) + Integer.toString(b);
        int ab = Integer.parseInt(abString);
        int doubleAb = 2 * a * b;

        if (ab >= doubleAb) {
            return ab;
        } else {
            return doubleAb;
        }
    }
}
