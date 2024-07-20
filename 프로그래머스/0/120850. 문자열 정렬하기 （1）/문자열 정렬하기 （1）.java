import java.util.*;

class Solution {
    public int[] solution(String my_string) {
 my_string = my_string.replaceAll("[a-z]", "");
        
        // 남은 숫자 문자열을 배열로 변환
        String[] arr = my_string.split("");
        
        // 정수 배열로 변환
        int[] answer = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            answer[i] = Integer.parseInt(arr[i]);
        }
        
        // 배열 정렬
        Arrays.sort(answer);
        
        return answer;
    }
}