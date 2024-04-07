import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        // 입력된 문자열을 소문자로 변경
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        // 각 문자열의 각 2개의 문자 조합과 등장 횟수를 저장할 Map 선언
        Map<String, Integer> map1 = new HashMap<>(); // str1
        Map<String, Integer> map2 = new HashMap<>(); // str2
        
        // 합집합을 구하기 위한 Set 선언
        Set<String> set = new HashSet<>();
        
        // 정답 변수 및 합집합의 크기를 저장할 변수 초기화
        int ans = 0, total = 0;

        // str1의 각 2개의 문자 조합과 등장 횟수 계산
        for (int i = 0; i < str1.length() - 1; i++) {
            String temp = str1.substring(i, i + 2);
            // 두 문자 모두 알파벳인 경우에만 처리
            if (Character.isAlphabetic(temp.charAt(0)) && Character.isAlphabetic(temp.charAt(1))) {
                map1.put(temp, map1.getOrDefault(temp, 0) + 1);
                set.add(temp); // 합집합을 구하기 위해 set에 추가
            }
        }

        // str2의 각 2개의 문자 조합과 등장 횟수 계산
        for (int i = 0; i < str2.length() - 1; i++) {
            String temp = str2.substring(i, i + 2);
            // 두 문자 모두 알파벳인 경우에만 처리
            if (Character.isAlphabetic(temp.charAt(0)) && Character.isAlphabetic(temp.charAt(1))) {
                map2.put(temp, map2.getOrDefault(temp, 0) + 1);
                set.add(temp); // 합집합을 구하기 위해 set에 추가
            }
        }

        // 합집합 구하기
        for (String s : set) 
            total += Math.max(map1.getOrDefault(s, 0), map2.getOrDefault(s, 0));

        // 교집합 구하기
        for (String s : map2.keySet()) 
            if (map1.containsKey(s)) 
                ans += Math.min(map1.get(s), map2.get(s));

        // 만약 합집합의 크기가 0이면 자카드 유사도는 1이므로 65536을 반환
        if (total == 0) 
            return 65536;
        
        // 교집합을 합집합으로 나눈 값을 반환
        return ans * 65536 / total;
    }
}
