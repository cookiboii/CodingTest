class Solution {
    boolean solution(String s) {
        boolean answer = true;
        char ch = 0;
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);

            if (ch == 'p' || ch == 'P') {
                cnt++;
            } else if (ch == 'y' || ch == 'Y') {
                cnt--;
            }
        }

        return cnt == 0;
    }
}
