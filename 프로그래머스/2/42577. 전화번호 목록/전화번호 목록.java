import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
                // 전화번호부 정렬
        Arrays.sort(phone_book);

        boolean answer = true;
          // 인접한 두 전화번호를 비교하여 접두어인지 확인
        for (int i = 0; i < phone_book.length - 1; i++) {
            // 현재 전화번호와 다음 전화번호 비교
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                answer= false; // 접두어인 경우 false 반환
            }
        }
    
        
        return answer;
    }
}