class Solution {
    public String solution(String my_string) {
        // 결과를 저장할 StringBuilder 선언
        StringBuilder result = new StringBuilder();
                                       
        // 주어진 문자열을 순회하면서 대소문자를 변환하여 결과에 추가합니다.
        for (int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);  //문자열을 캐릭터 타입으로 바꿔준다
            // 대문자인 경우
            if (Character.isUpperCase(ch)) {
                // 소문자로 변환하여 결과에 추가합니다.
                result.append(Character.toLowerCase(ch));
            } else { // 소문자인 경우
                // 대문자로 변환하여 결과에 추가합니다.
                result.append(Character.toUpperCase(ch));
            }
        }

        // 결과를 문자열로 반환합니다.
        return result.toString();
    }
}
