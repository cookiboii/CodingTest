import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> solution(int[] num_list, int n) {
        List<Integer> result = new ArrayList<>();

        // num_list의 첫 번째 원소부터 n개 간격으로 리스트에 추가
        for (int i = 0; i < num_list.length; i += n) {
            result.add(num_list[i]);
        }

        return result;
    }
}
