class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        if(a != b && a != c && b != c) {
            // a, b, c 모두 다르면
            answer = a + b + c;
        } else if ((a == b && a != c) || (a == c && a != b) || (b == c && b != a)) {
            // a, b 중 둘만 같으면
            answer = (a + b + c) * (a * a + b * b + c * c);
        } else if (a == b && b == c) {
            // a, b, c 모두 같으면
            answer = (a + b + c) * (a * a + b * b + c * c) * (a * a * a + b * b * b + c * c * c);
        }
        return answer;
    }

   
}
