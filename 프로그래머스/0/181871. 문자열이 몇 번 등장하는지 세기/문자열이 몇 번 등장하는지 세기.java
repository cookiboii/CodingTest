class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        int patLength = pat.length();  // pat의 길이를 계산

        for (int i = 0; i <= myString.length() - patLength; i++) {
            // myString의 i번째부터 pat 길이만큼의 부분 문자열이 pat과 일치하는지 확인
            if (myString.substring(i, i + patLength).equals(pat)) {
                answer++;
            }
        }  
        
        return answer;
    }
}
