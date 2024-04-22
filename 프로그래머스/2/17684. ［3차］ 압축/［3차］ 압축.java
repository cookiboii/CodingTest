import java.util.*;

class Solution {
    public static int[] solution(String msg) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        // A부터 Z까지 초기화
        for(int i = 0; i < 26; i++)
            map.put(String.valueOf((char)('A' + i)), i + 1);

        // 문자열 처리
        for(int i = 0; i < msg.length();) {
            int end = i + 1;
            while(end <= msg.length()) {
                String sub = msg.substring(i, end);
                if(map.containsKey(sub)) {
                    end++;
                }
                else {
                    // 새로운 단어 등록 후 색인 번호 출력
                    list.add(map.get(msg.substring(i, end - 1)));
                    map.put(sub, map.size() + 1);
                    break;
                }
            }
            if(end > msg.length())
                list.add(map.get(msg.substring(i, end - 1)));
            
            i = end - 1;
        }

        // 리스트를 배열로 변환
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);

        return ans;
    }
}
