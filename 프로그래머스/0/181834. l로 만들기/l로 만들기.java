class Solution {
    public String solution(String myString) {
        String answer = "";
        
        answer = myString.replaceAll("[^l-z]","l");
        
        return answer;
    }
}