import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<Character, Integer> map = new HashMap<>();
        
        // 성격 유형의 초기 점수를 0으로 설정
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);
 
        // 설문조사 응답을 기반으로 성격 유형 점수를 계산
        for (int i = 0; i < survey.length; i++) {
            char firstType = survey[i].charAt(0);
            char secondType = survey[i].charAt(1);
            int choice = choices[i];
            
            if (choice < 4) { // 비동의 쪽 응답인 경우
                map.put(firstType, map.get(firstType) + (4 - choice));
            } else if (choice > 4) { // 동의 쪽 응답인 경우
                map.put(secondType, map.get(secondType) + (choice - 4));
            }
        }
 
        // 각 성격 유형 쌍의 점수를 비교하여 최종 성격 유형을 결정
        answer += map.get('R') >= map.get('T') ? "R" : "T";
        answer += map.get('C') >= map.get('F') ? "C" : "F";
        answer += map.get('J') >= map.get('M') ? "J" : "M";
        answer += map.get('A') >= map.get('N') ? "A" : "N";
        
        return answer;
    }
}
