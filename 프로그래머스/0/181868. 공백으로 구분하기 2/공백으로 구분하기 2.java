class Solution {
    public String[] solution(String my_string) {
        // 문자열을 공백 기준으로 분할하고, 결과를 배열로 반환합니다.
        // "\\s+" 정규 표현식은 하나 이상의 공백을 의미합니다.
        String[] answer = my_string.trim().split("\\s+");
        return answer;
    }
}
