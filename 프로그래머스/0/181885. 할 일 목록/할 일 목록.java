
import java.util.*;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        // 완료되지 않은 할 일을 저장할 리스트 초기화
        List<String> incompleteTasks = new ArrayList<>();
        
        // todo_list와 finished 배열을 순회
        for (int i = 0; i < todo_list.length; i++) {
            // 만약 현재 할 일이 완료되지 않았다면
            if (!finished[i]) {
                // 리스트에 추가
                incompleteTasks.add(todo_list[i]);
            }
        }
        
        // 리스트를 배열로 변환하여 반환
        String[] answer = new String[incompleteTasks.size()];
        incompleteTasks.toArray(answer);
        return answer;
    }
}
