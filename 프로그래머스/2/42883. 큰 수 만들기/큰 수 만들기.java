import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);
            
            // 스택이 비어 있지 않고, 현재 문자보다 작은 문자들이 스택에 존재하며, 제거할 문자가 남아 있을 때 제거
            while (!stack.isEmpty() && stack.peek() < current && k > 0) {
                stack.pop();
                k--;
            }
            
            // 현재 문자를 스택에 추가
            stack.push(current);
        }
        
        // 아직 제거해야 할 문자가 남아 있는 경우 처리
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        // 스택을 문자열로 변환
        StringBuilder answer = new StringBuilder();
        for (char digit : stack) {
            answer.append(digit);
        }
        
        return answer.toString();
    }
}
