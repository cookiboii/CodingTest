import java.util.Arrays;

class Solution {
    public int solution(String before, String after) {
        // before과 after를 각각 char 배열로 변환한 후 정렬합니다.
        char[] be = before.toCharArray();
        char[] af = after.toCharArray();

        Arrays.sort(be);
        Arrays.sort(af);

        // 정렬된 char 배열을 다시 문자열로 변환합니다.
        String str1 = new String(be);
        String str2 = new String(af);

        // 변환된 문자열이 동일한지 비교합니다.
        return str1.equals(str2) ? 1 : 0;
    }
}
