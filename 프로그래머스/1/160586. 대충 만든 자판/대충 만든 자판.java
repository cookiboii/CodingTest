import java.util.*;

class Solution {    
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length]; // 결과를 저장할 배열
        Map<Character, Integer> map = new HashMap<>(); // 각 문자와 해당 키의 최소 누름 횟수를 저장할 맵

        // keymap 배열을 순회하며 각 문자의 최소 누름 횟수를 맵에 저장
        for (String s : keymap) {
            for (int i = 0; i < s.length(); i++) {
                char key = s.charAt(i); // 현재 문자를 가져옴
                // 현재 문자의 누름 횟수(i + 1)를 맵에 저장, 이미 있는 경우 최소값을 저장
                map.put(key, Math.min(i + 1, map.getOrDefault(key, Integer.MAX_VALUE)));
            }
        }

        // targets 배열을 순회하며 각 문자열의 총 누름 횟수를 계산
        for (int i = 0; i < targets.length; i++) {
            String s = targets[i]; // 현재 타겟 문자열
            for (int j = 0; j < s.length(); j++) {
                char key = s.charAt(j); // 현재 타겟 문자열의 문자
                if (map.containsKey(key)) { // 맵에 해당 문자가 존재하면
                    answer[i] += map.get(key); // 누름 횟수를 더함
                } else { // 맵에 해당 문자가 없으면
                    answer[i] = -1; // 결과를 -1로 설정
                    break; // 더 이상 계산할 필요 없으므로 루프 탈출
                }
            }
        }

        return answer; // 결과 배열 반환
    }
}
