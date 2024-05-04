import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        // 토핑 종류별 개수를 저장하는 맵
        Map<Integer, Integer> toppingCounts = new HashMap<>();
        // 사용된 토핑 종류를 저장하는 세트
        Set<Integer> usedToppings = new HashSet<>();

        // 토핑 종류별 개수 세기
        for (int t : topping) {
            if (toppingCounts.containsKey(t)) {
                toppingCounts.put(t, toppingCounts.get(t) + 1);
            } else {
                toppingCounts.put(t, 1);
            }
        }

        // 사용된 토핑 종류를 세면서 조합 가능한 토핑 수 세기
        for (int t : topping) {
            // 해당 토핑 종류 개수 감소
            toppingCounts.put(t, toppingCounts.get(t) - 1);
            // 사용된 토핑 세트에 추가
            usedToppings.add(t);
            // 해당 토핑 종류가 모두 사용되었을 경우 맵에서 제거
            if (toppingCounts.get(t) == 0) {
                toppingCounts.remove(t);
            }
            // 사용된 토핑 종류 수와 토핑 종류별 개수가 일치하는지 확인하여 조합 가능한 토핑 수 증가
            if (toppingCounts.size() == usedToppings.size()) {
                answer++;
            }
        }
        return answer;
    }
}
