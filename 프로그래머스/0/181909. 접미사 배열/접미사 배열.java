import java.util.Arrays;

class Solution {
    public String[] solution(String my_string) {
        // 문자열의 길이만큼의 배열을 초기화
        String[] answer = new String[my_string.length()];
        
        // 문자열의 모든 접미사를 생성하여 배열에 저장
        for (int i = 0; i < my_string.length(); i++) {
            answer[i] = my_string.substring(i);
        }
        
        // 배열을 사전순으로 정렬
        Arrays.sort(answer);
        
        return answer;
    }
}
