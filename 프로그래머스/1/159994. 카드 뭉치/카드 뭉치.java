import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // cards와 goal을 deque로 변환
        ArrayDeque<String> cardsDeque1 = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> cardsDeque2 = new ArrayDeque<>(Arrays.asList(cards2));
        ArrayDeque<String> goalDeque = new ArrayDeque<>(Arrays.asList(goal));

        // goalDeque에 문자열이 남아 있으면 계속 반복
        while (!goalDeque.isEmpty()) {
            // cardsDeque1의 front와 일치하는 경우
            if (!cardsDeque1.isEmpty() && cardsDeque1.peekFirst().equals(goalDeque.peekFirst())) {
                cardsDeque1.pollFirst();
                goalDeque.pollFirst();
            } 
            // cardsDeque2의 front와 일치하는 경우
            else if (!cardsDeque2.isEmpty() && cardsDeque2.peekFirst().equals(goalDeque.peekFirst())) {
                cardsDeque2.pollFirst();
                goalDeque.pollFirst();
            } 
            // 두 덱 모두 해당 문자열이 없는 경우
            else {
                // goal을 만들 수 없으므로 No 반환
                return "No";
            }
        }

        // goalDeque가 모두 소진된 경우
        // goal을 만들 수 있으므로 Yes 반환
        return "Yes";
    }
}
