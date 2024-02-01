
import java.util.Arrays;
class Solution {
    public String solution(String s) {
        String answer = "";
        
        char[] charArray = s.toCharArray();  //캐릭터타입 배열로 만들어준다
        Arrays.sort(charArray);
        
        answer = new StringBuilder(new String(charArray)).reverse().toString();
        return answer;
    }
}