import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        // 결과를 저장할 리스트 생성 (배열 크기를 동적으로 조정할 수 있도록 ArrayList 사용)
        List<Integer> list = new ArrayList<>();
        
        // 입력된 문자열 배열(intStrs)을 순회
        for (String str : intStrs) {
            // 문자열의 특정 구간을 추출하여 정수로 변환
            int n = Integer.parseInt(str.substring(s, s + l));
            
            // 변환된 정수가 k보다 큰 경우 리스트에 추가
            if (n > k) {
                list.add(n);
            }
        }
        
        // 리스트의 내용을 배열로 변환
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);  // 리스트의 각 값을 배열에 복사
        }
        
        // 결과 배열 반환
        return result;
    }
}