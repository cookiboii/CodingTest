import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        // 각 문자의 마지막 등장 위치를 기록하기 위한 해시맵
        HashMap<Character, Integer> lastSeen = new HashMap<>();

        char[] arr = s.toCharArray();

        // 문자열을 왼쪽부터 순회하면서 각 문자의 이전 등장 위치를 계산
        for (int i = 0; i < arr.length; i++) {
            char currentChar = arr[i];
            if (lastSeen.containsKey(currentChar)) {
                answer[i] = i - lastSeen.get(currentChar); // 이전 등장 위치와의 거리를 계산하여 결과 배열에 저장
            } else {
                answer[i] = -1; // 이전 등장 위치가 없는 경우 -1로 설정
            }
            lastSeen.put(currentChar, i); // 현재 문자의 등장 위치를 갱신
        }

        return answer;
    }

  
}