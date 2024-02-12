import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        
        // 문자열 길이만큼 반복하여 회전하며 검사
        for (int i = 0; i < s.length(); i++) {
            // 문자열 회전
            String rotated = rotate(s, i);
            // 올바른 괄호 문자열인지 확인
            if (isValid(rotated)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    // 문자열을 왼쪽으로 x만큼 회전하는 메소드
    private String rotate(String s, int x) {
        return s.substring(x) + s.substring(0, x);
    }
    
    // 올바른 괄호 문자열인지를 확인하는 메소드
    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        // 문자열을 순회하며 괄호를 스택에 넣고 제거하면서 확인
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (!stack.isEmpty() && ((c == ')' && stack.peek() == '(') || (c == ']' && stack.peek() == '[') || (c == '}' && stack.peek() == '{'))) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
