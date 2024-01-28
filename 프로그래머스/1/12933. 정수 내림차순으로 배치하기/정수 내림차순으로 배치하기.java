import java.util.*;

class Solution {
    public long solution(long n) {
      char[] digits = Long.toString(n).toCharArray();
          Arrays.sort(digits);
        
          StringBuilder reversed = new StringBuilder();
        for (int i = digits.length - 1; i >= 0; i--) {
            reversed.append(digits[i]);
        }
        return Long.parseLong(reversed.toString()); 
    }
         
}

