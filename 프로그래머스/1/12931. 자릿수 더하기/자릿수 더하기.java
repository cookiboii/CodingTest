import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int sum =0;
        
         String number = Integer.toString(n);
 for (int i = 0; i < number.length(); i++) {
            char nm = number.charAt(i);
          answer += Character.getNumericValue(nm);
        }

        return answer;
    }
}