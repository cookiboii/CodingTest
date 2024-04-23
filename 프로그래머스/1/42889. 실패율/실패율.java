import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Double> falseMap = new HashMap<>();
        double totalUser = (double) stages.length;
        
        // 각 스테이지에 도달한 플레이어 수 계산
        for (int i = 0; i < stages.length; i++) {
            map.put(stages[i], map.getOrDefault(stages[i], 0) + 1);
        }
        
        // 스테이지 실패율 계산
        for (int i = 1; i <= N; i++) {
            if (map.containsKey(i)) {
                falseMap.put(i, map.get(i) / totalUser);
                totalUser -= map.get(i);
            } else {
                falseMap.put(i, 0.0);
            }
        }
        
        // 실패율 내림차순으로 정렬
        List<Integer> sortStages = new ArrayList<>(falseMap.keySet());
        Collections.sort(sortStages, (s1, s2) -> falseMap.get(s2).compareTo(falseMap.get(s1)));
        
        // 정렬된 스테이지 번호를 배열에 저장
        for (int i = 0; i < N; i++) {
            answer[i] = sortStages.get(i);
        }
        
        return answer;
    }
}
