class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;  // Initialize answer to 0 instead of 1234567890
        
        for (int i = 0; i <a.length; i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }
}
