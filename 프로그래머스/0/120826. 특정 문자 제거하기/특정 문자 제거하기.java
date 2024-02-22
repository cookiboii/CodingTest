class Solution {
    public String solution(String my_string, String letter) {
        StringBuilder result = new StringBuilder();
        
        char target = letter.charAt(0);
        for (int i = 0; i < my_string.length(); i++) {
            char currentChar = my_string.charAt(i);
            if (currentChar != target) {
                result.append(currentChar);
            }
        }
        
        return result.toString();
    }
}
