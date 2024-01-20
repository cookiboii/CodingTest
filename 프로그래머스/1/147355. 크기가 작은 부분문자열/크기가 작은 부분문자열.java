class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int tlen = t.length();

        for (int i = 0; i <= tlen - p.length(); i++) {
            String subStr = t.substring(i, i + p.length());
            if (Long.parseLong(subStr) <= Long.parseLong(p)) {
                answer++;
            }
        }

        return answer;
    }
}