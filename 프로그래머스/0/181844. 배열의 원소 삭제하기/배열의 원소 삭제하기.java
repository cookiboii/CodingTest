import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        // HashSet을 사용하여 삭제할 값들을 빠르게 확인할 수 있도록 합니다.
        Set<Integer> deleteSet = new HashSet<>();
        for (int num : delete_list) {
            deleteSet.add(num);
        }

        // 삭제된 요소를 제외한 새로운 배열을 생성합니다.
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (!deleteSet.contains(num)) {
                list.add(num);
            }
        }

        // 새로운 배열을 반환합니다.
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
