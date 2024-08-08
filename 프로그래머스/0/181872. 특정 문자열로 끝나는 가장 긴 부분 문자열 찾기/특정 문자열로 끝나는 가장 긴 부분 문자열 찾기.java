class Solution {
    public String solution(String myString, String pat) {
        String answer = "";
        int lastIndex = myString.lastIndexOf(pat);
        
        if (lastIndex != -1) {
            return myString.substring(0, lastIndex + pat.length());  // 해당 인덱스까지의 부분 문자열을 반환
        }
         answer =""; 
        
        return answer;
    }
}