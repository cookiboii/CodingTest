class Solution {
    public String solution(String my_string, String alp) {
        // 주어진 문자열을 문자 배열로 변환
        char[] charArray = my_string.toCharArray();
        
        // 주어진 문자열의 길이만큼 반복
        for (int i = 0; i < my_string.length(); i++) {
            // 현재 문자가 alp와 같다면 대문자로 변경
            if (charArray[i] == alp.charAt(0)) {
                charArray[i] = Character.toUpperCase(charArray[i]);
            }
        }
        
        // 대문자로 변경된 문자 배열을 다시 문자열로 변환하여 반환
        return new String(charArray);
    }
}
