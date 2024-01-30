class Solution {
    public String solution(String phone_number) {
        char[] phone_array = phone_number.toCharArray();
        
        // 뒤에서 4자리를 제외한 나머지 숫자를 *으로 가림
        for (int i = 0; i < phone_number.length() - 4; i++) {
            phone_array[i] = '*';
        }
        
        // char 배열을 다시 String으로 변환하여 반환
        return new String(phone_array);
    }
}