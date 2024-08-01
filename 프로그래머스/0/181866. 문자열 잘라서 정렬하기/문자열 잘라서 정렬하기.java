import java.util.Arrays;
class Solution {
    public String[] solution(String myString) {
        // "x"를 기준으로 문자열을 자릅니다.
        String[] parts = myString.split("x");
        
        // 유효한 문자열의 개수를 셉니다.
        int count = 0;
        for (String part : parts) {
            if (!part.isEmpty()) {
                count++;
            }
        }
        
        // 유효한 문자열을 저장할 배열을 생성합니다.
        String[] answer = new String[count];
        int index = 0;
        for (String part : parts) {
            if (!part.isEmpty()) {
                answer[index++] = part;
            }
        }
        
        // 배열을 사전순으로 정렬합니다.
        Arrays.sort(answer);
        
        return answer;
    }
}
