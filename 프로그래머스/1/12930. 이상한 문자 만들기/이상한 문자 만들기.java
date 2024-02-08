class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();

        // 주어진 문자열을 단어로 분리
        String[] words = s.split(" ",-1);

        // 각 단어에 대해 짝수번째 문자는 대문자로, 홀수번째 문자는 소문자로 변경
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                if (j % 2 == 0) { // 짝수번째 문자인 경우
                    answer.append(Character.toUpperCase(c));
                } else { // 홀수번째 문자인 경우
                    answer.append(Character.toLowerCase(c));
                }
            }
            // 단어 사이에 공백 추가
            if (i < words.length - 1) {
                answer.append(" ");
            }
        }

        return answer.toString();
    }
}
