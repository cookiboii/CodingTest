import java.util.*;

class Solution {
    public int[] solution(long n) {
          String str = Long.toString(n);
        
          ArrayList<Integer> reversedDigits = new ArrayList<>();
        
           for (int i = str.length() - 1; i >= 0; i--) {
            // Convert character to integer and add to the ArrayList
            reversedDigits.add(Character.getNumericValue(str.charAt(i)));
        }
        int[] answer = new int[reversedDigits.size()];
        for (int i = 0; i < reversedDigits.size(); i++) {
            answer[i] = reversedDigits.get(i);
        }
        
      
        return answer;
    }
}