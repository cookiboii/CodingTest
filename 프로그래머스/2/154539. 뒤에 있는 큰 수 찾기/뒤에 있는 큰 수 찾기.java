import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        // 각 원소에 대해 뒷 큰수를 찾기 위해 배열을 역순으로 순회
        for (int i = numbers.length - 1; i >= 0; i--) {
            int num = numbers[i];

            // 현재 원소보다 작거나 같은 숫자는 스택에서 제거
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }

            // 스택이 비어있지 않다면 현재 원소보다 큰 수가 스택에 존재함
            // 따라서 현재 원소의 뒷 큰수는 스택의 맨 위에 있는 수
            if (!stack.isEmpty()) {
                answer[i] = stack.peek();
            } else {
                // 스택이 비어있다면 현재 원소보다 큰 수가 존재하지 않음
                answer[i] = -1;
            }

            // 현재 원소를 스택에 추가
            stack.push(num);
        }

        return answer;
    }
}
