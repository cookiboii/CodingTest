class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        StringBuilder answer = new StringBuilder(); // 문자열을 효율적으로 결합하기 위해 StringBuilder 사용

        // 각 문자열의 지정된 부분을 추출하여 answer에 추가
        for (int i = 0; i < my_strings.length; i++) {
            int start = parts[i][0];
            int end = parts[i][1];
            // 부분 문자열을 추출하고 StringBuilder에 추가
            answer.append(my_strings[i].substring(start, end + 1));
        }

        return answer.toString(); // 최종 문자열 반환
    }
}
