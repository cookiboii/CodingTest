import java.util.*;
class Solution {
    public String solution(String my_string) {
        String answer = "";
  char[] chars = my_string.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
        
    }
}