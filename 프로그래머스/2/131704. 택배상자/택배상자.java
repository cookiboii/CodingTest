import java.util.*;

class Solution {
    
    public int solution(int[] order) {
        int answer = 0; // 트럭에 실을 수 있는 상자의 개수를 추적하기 위한 변수
        Stack<Integer> stack = new Stack<>(); // 보조 컨테이너 벨트를 위한 스택
        int size = order.length; // order 배열의 길이 (상자의 총 개수)
        int index = 0; // 현재 처리 중인 order 배열의 인덱스

        // 1번 상자부터 size번 상자까지 순차적으로 처리
        for(int i = 1 ; i <= size ; i++) {
            // 현재 처리 중인 상자가 원하는 순서의 상자와 다르면 stack에 push
            if(order[index] != i) {
                stack.push(i);
            } else {
                // 원하는 순서의 상자와 같으면 바로 트럭에 싣고 인덱스 및 answer 증가
                index++;
                answer++;
            }
            
            // stack이 비어있지 않고, stack의 맨 위 상자가 다음으로 필요한 상자와 같으면
            while(!stack.isEmpty() && stack.peek() == order[index]) {
                stack.pop(); // stack에서 상자를 꺼내서 트럭에 싣기
                index++; // order 배열의 다음 상자로 이동
                answer++; // 트럭에 실은 상자 수 증가
            }
        }
        
        return answer; // 최종적으로 트럭에 실을 수 있는 상자의 개수 반환
    }
}
